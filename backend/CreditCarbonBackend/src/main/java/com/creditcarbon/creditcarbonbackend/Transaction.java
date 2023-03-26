package com.creditcarbon.creditcarbonbackend;

public class Transaction {


    private Categories category;

    private String transactionId;

    private Amount amount;

    private String mcc;

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    private String transactionDetail;

    public Transaction(Categories category, String transactionId, Amount amount, String transactionDetail, String mcc) {
        this.category = category;
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionDetail = transactionDetail;
        this.mcc = mcc;
    }
}

enum Categories {
    FOOD, ENTERTAINMENT, SHOPPING, TRANSPORTATION
}
