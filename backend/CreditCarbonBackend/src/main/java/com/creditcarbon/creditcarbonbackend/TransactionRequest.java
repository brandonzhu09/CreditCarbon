package com.creditcarbon.creditcarbonbackend;


public class TransactionRequest {

    private final String transactionId;

    private final String mcc;

    private final Amount amount;

    private final String cardBrand;

    public TransactionRequest(String transactionId, String mcc, int cost, String cardBrand) {
        this.transactionId = transactionId;
        this.mcc = mcc;
        this.amount = new Amount(cost, "USD");
        this.cardBrand = cardBrand;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMcc() {
        return mcc;
    }

    public Amount getAmount() {
        return amount;
    }

    public String getCardBrand() {
        return cardBrand;
    }
}

;
