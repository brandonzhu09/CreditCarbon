package com.creditcarbon.creditcarbonbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastercard.developer.signers.OkHttpSigner;
import com.mastercard.developer.utils.AuthenticationUtils;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiClient {

    private final ObjectMapper mapper = new ObjectMapper();

    private final OkHttpClient client;

    private final String consumerKey = "iC1ZTMs-DrQjpZrg0eRTDVJc5C6PodbOyFzDUlwY32d294cb!a2fd2e42c55d466fbb0ce2e063d1df8f0000000000000000";
    private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpSigner signer;

    private final PrivateKey signingKey;

    public ApiClient() {
        try {
            client = new OkHttpClient();
            signingKey = AuthenticationUtils.loadSigningKey(
                    "C:\\Users\\shahr\\IdeaProjects\\CreditCarbon\\backend\\CreditCarbonBackend\\src\\main\\resources\\hoohacks-sandbox.p12",
                    "keyalias",
                    "keystorepassword"
            );
            signer = new OkHttpSigner(consumerKey, signingKey);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to intialize ApiClient");
        }


    }

    public List<TransactionResult> sendTransactionData(List<TransactionRequest> transactions) {

        System.out.println("SENDING REQUEST");


        StringWriter sw = new StringWriter();


        TransactionResult[] resultList;
        try {
            mapper.writeValue(sw, transactions);

            String payload = sw.toString();

            sw.close();

            RequestBody body = RequestBody.create(JSON, payload);

            Request.Builder request = new Request.Builder().url("https://sandbox.api.mastercard.com/carbon/transaction-footprints").post(body);

            signer.sign(request);

            Call call = client.newCall(request.build());

            Response response = call.execute();


            String json = response.body().string();
            resultList = mapper.readValue(json, TransactionResult[].class);
        } catch (IOException e) {
            throw new RuntimeException("Error in send transactions");
        }

        return new ArrayList<>(List.of(resultList));

    }

}
