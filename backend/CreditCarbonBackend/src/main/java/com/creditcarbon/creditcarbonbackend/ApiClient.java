package com.creditcarbon.creditcarbonbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.developer.encryption.FieldLevelEncryption;
import com.mastercard.developer.encryption.FieldLevelEncryptionConfigBuilder;
import com.mastercard.developer.signers.OkHttpSigner;
import com.mastercard.developer.utils.AuthenticationUtils;
import com.mastercard.developer.utils.EncryptionUtils;
import okhttp3.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.List;

public class ApiClient {


    private static FieldLevelEncryption fieldLevelEncrytion = null;

    private static final ObjectMapper mapper = new ObjectMapper();


    public void initalizeFieldEncrytion() throws URISyntaxException, FileNotFoundException, CertificateException {
        String encryptPath = Paths.get(this.getClass().getClassLoader().getResource("carbon_calculatorClientEnc1679770975.pem").toURI()).toFile().getAbsolutePath();
        Certificate encryptCert = EncryptionUtils.loadEncryptionCertificate(encryptPath);

        FieldLevelEncryptionConfigBuilder.aFieldLevelEncryptionConfig()
                .withEncryptionCertificate(encryptCert);
    }

    public void sendTransactionData(List<TransactionRequest> transactions) throws UnrecoverableKeyException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {

        System.out.println("SENDING REQUEST");
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        String consumerKey = "iC1ZTMs-DrQjpZrg0eRTDVJc5C6PodbOyFzDUlwY32d294cb!a2fd2e42c55d466fbb0ce2e063d1df8f0000000000000000";

        PrivateKey signingKey = AuthenticationUtils.loadSigningKey(
                "C:\\Users\\shahr\\IdeaProjects\\CreditCarbon\\backend\\CreditCarbonBackend\\src\\main\\resources\\hoohacks-sandbox.p12",
                "keyalias",
                "keystorepassword"
        );

        StringWriter sw = new StringWriter();


        mapper.writeValue(sw, transactions);

        String payload = sw.toString();
        sw.close();

        System.out.println(payload);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, payload);

        Request.Builder request = new Request.Builder().url("https://sandbox.api.mastercard.com/carbon/transaction-footprints").post(body);

        OkHttpSigner signer = new OkHttpSigner(consumerKey, signingKey);

        signer.sign(request);

        Call call = client.newCall(request.build());

        Response response = call.execute();

        var typeFactory = mapper.getTypeFactory();

        String json = response.body().string();
        TransactionResult[] resultList = mapper.readValue(json, TransactionResult[].class);

        System.out.println(resultList[0].category().mainCategory() + "  " +  resultList[0].category().subCategory());


    }

}
