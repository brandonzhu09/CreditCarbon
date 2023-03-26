package com.creditcarbon.creditcarbonbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "api/transactions")
public class CarbonDataController {



    private final ApiClient apiClient;
    @Autowired
    public CarbonDataController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping(path = "/sample")
    public List<TransactionResult> getSampleResults() {
        return apiClient.sendTransactionData(sampleTransactionsReq);
    }

    @GetMapping(path = "/recommendation")
    public List<Recommendation> getRecommendations() {
        List<TransactionResult> results = apiClient.sendTransactionData(sampleTransactionsReq);
        return null;
    }

    @GetMapping(path = "/category")
    public List<TransactionCategory> getTransactionCategory() {
        List<TransactionCategory> result = new ArrayList<>();

        int foodKG = 0;
        int entertainmentKG = 0;
        int shoppingKG = 0;
        int transportationKG = 0;

        List<TransactionResult> transactionResults = apiClient.sendTransactionData(sampleTransactionsReq);
        for(TransactionResult r : transactionResults) {
            if(r.category().mainCategory().contains("Food"))
                foodKG += (r.carbonEmissionInGrams()/1000);
            else if(r.category().mainCategory().contains("Shopping"))
                shoppingKG += r.carbonEmissionInGrams()/1000;
            else if(r.category().mainCategory().contains("Entertainment"))
                entertainmentKG += r.carbonEmissionInGrams()/1000;
            else if(r.category().mainCategory().contains("Transportation"))
                transportationKG += r.carbonEmissionInGrams()/1000;
        }

        result.add(new TransactionCategory("FOOD", foodKG));
        result.add(new TransactionCategory("SHOPPING", shoppingKG));
        result.add(new TransactionCategory("ENTERTAINMENT", entertainmentKG));
        result.add(new TransactionCategory("TRANSPORTATION", transportationKG));

        return result;
    }

    @GetMapping(path = "/list")
    public List<Transaction> getTransactionsList() {
        return sampleTransactions;
    }






    private final static List<TransactionRequest> sampleTransactionsReq;

    private final static List<Transaction> sampleTransactions;

    static {
        Random rand = new Random();

        sampleTransactionsReq = new ArrayList<>();
        sampleTransactions = new ArrayList<>();

        List<String> stores = List.of("H&M", "Nike", "Old Navy", "Game Stop");

        int i = 0;
        while(i < 11)
        {
            //Shopping DepartmentStore
            var t = new TransactionRequest(i + "", "2842", rand.nextInt(15, 45), "MA");
            sampleTransactionsReq.add(t);
            var tFull = new Transaction(Categories.SHOPPING, i + "", t.getAmount(), stores.get(rand.nextInt(stores.size())), "2842");
            sampleTransactions.add(tFull);
            i++;
        }

        i = 0;

        while(i < 5)
        {   //Transportation  motorvehicle
            var t = new TransactionRequest(i + "0", "5541" , rand.nextInt(25, 35), "MA");
            sampleTransactionsReq.add(t);
            var tFull = new Transaction(Categories.TRANSPORTATION, i + "0", t.getAmount(), "Gas Station", "5541");
            sampleTransactions.add(tFull);
            i++;
        }

        i = 0;

        while(i < 4)
        {   //Food/Beverage Groceries
            var t = new TransactionRequest(i + "00", "5411" , rand.nextInt(100, 150), "MA");
            sampleTransactionsReq.add(t);
            var tFull = new Transaction(Categories.TRANSPORTATION, i + "0", t.getAmount(), "Costco", "5411");
            sampleTransactions.add(tFull);
            i++;
        }

        i = 0;

        stores = List.of("Netflix", "Movie Theater");

        while(i < 4)
        {   //entertainment
            var t = new TransactionRequest(i + "000", "7832" , rand.nextInt(30, 45), "MA");
            sampleTransactionsReq.add(t);
            var tFull = new Transaction(Categories.ENTERTAINMENT, i + "", t.getAmount(), stores.get(rand.nextInt(stores.size())), "7832");
            sampleTransactions.add(tFull);
            i++;
        }

    }

}
