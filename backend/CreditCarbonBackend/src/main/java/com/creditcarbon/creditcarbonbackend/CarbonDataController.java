package com.creditcarbon.creditcarbonbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "api/transactions")
public class CarbonDataController {

    private static final DecimalFormat df = new DecimalFormat("0.00");


    private final ApiClient apiClient;

    List<TransactionResult> cache = null;
    @Autowired
    public CarbonDataController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping(path = "/sample")
    public List<TransactionResult> getSampleResults() {
        return cache == null ? cache = apiClient.sendTransactionData(sampleTransactionsReq) : cache;
    }

    @GetMapping(path = "/recommendation")
    public List<Recommendation> getRecommendations() {
        List<Recommendation> result = new ArrayList<>(3);

        List<TransactionCategory> categories = getTransactionCategory();

        TransactionCategory max = categories.stream().max(Comparator.comparing(TransactionCategory::amountInKg)).get();

        System.out.println(max.category() + max.totalSpending());

        int treesReplaced = (int)(max.totalSpending() * .1);

        result.add(new Recommendation("Your highest source of emissions is from spending in " + max.category() + "," +
                " so that should be an area of focus for reducing emissions"));

        result.add(new Recommendation("If you reduced your spending in " + max.category() + " by 10% " +
                "you could plant " + treesReplaced + " trees instead"));


        TransactionCategory maxSpending = categories.stream().max(Comparator.comparingDouble((a) -> a.amountInKg()/a.totalSpending())).get();

        double ePerDollar = maxSpending.amountInKg()/maxSpending.totalSpending();



        result.add(new Recommendation("You get the most emissions per dollar from " + maxSpending.category() + "( " + df.format(ePerDollar)  + "kg/$ )" + ", " +
                "reducing your spending here will result in the most emissions reduction"));


        return result;
    }

    @GetMapping(path = "/category")
    public List<TransactionCategory> getTransactionCategory() {
        List<TransactionCategory> result = new ArrayList<>();

        double foodKG = 0;
        double entertainmentKG = 0;
        double shoppingKG = 0;
        double transportationKG = 0;
        double foodCost = 0;
        double entertainmentCost = 0;
        double shoppingCost = 0;
        double transportationCost = 0;

        List<TransactionResult> transactionResults = cache == null ? cache = apiClient.sendTransactionData(sampleTransactionsReq) : cache;
        for(TransactionResult r : transactionResults) {
            if(r.category().mainCategory().contains("Food"))
            {
                foodKG += (r.carbonEmissionInGrams()/1000);
                for(Transaction s : sampleTransactions)
                {
                    if(s.getTransactionId().equals(r.transactionId()))
                        foodCost += s.getAmount().value();
                }
            }
            else if(r.category().mainCategory().contains("Shopping"))
            {
                shoppingKG += (r.carbonEmissionInGrams()/1000);
                for(Transaction s : sampleTransactions)
                {
                    if(s.getTransactionId().equals(r.transactionId()))
                        shoppingCost += s.getAmount().value();
                }
            }
            else if(r.category().mainCategory().contains("Entertainment"))
            {
                entertainmentKG += (r.carbonEmissionInGrams()/1000);
                for(Transaction s : sampleTransactions)
                {
                    if(s.getTransactionId().equals(r.transactionId()))
                        entertainmentCost += s.getAmount().value();
                }
            }
            else if(r.category().mainCategory().contains("Transportation"))
            {
                transportationKG += (r.carbonEmissionInGrams()/1000);
                for(Transaction s : sampleTransactions)
                {
                    if(s.getTransactionId().equals(r.transactionId()))
                        transportationCost += s.getAmount().value();
                }
            }
        }

        double sum = foodKG + shoppingKG + entertainmentKG + transportationKG;

        result.add(new TransactionCategory("FOOD", (int)foodKG, foodCost, (int)(100 * (foodKG/sum))));
        result.add(new TransactionCategory("SHOPPING", (int)shoppingKG, shoppingCost,(int)(100 * (shoppingKG/sum))));
        result.add(new TransactionCategory("ENTERTAINMENT", (int)entertainmentKG,entertainmentCost,(int)(100 * (entertainmentKG/sum))));
        result.add(new TransactionCategory("TRANSPORTATION", (int)transportationKG, transportationCost,(int)(100 * (transportationKG/sum))));

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
            var tFull = new Transaction(Categories.TRANSPORTATION, i + "00", t.getAmount(), "Costco", "5411");
            sampleTransactions.add(tFull);
            i++;
        }

        i = 0;

        stores = List.of("Netflix", "Movie Theater");

        while(i < 4)
        {   //entertainment
            var t = new TransactionRequest(i + "000", "7832" , rand.nextInt(30, 45), "MA");
            sampleTransactionsReq.add(t);
            var tFull = new Transaction(Categories.ENTERTAINMENT, i + "000", t.getAmount(), stores.get(rand.nextInt(stores.size())), "7832");
            sampleTransactions.add(tFull);
            i++;
        }

    }

}
