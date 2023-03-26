package com.creditcarbon.creditcarbonbackend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionResult(String transactionId, double carbonEmissionInGrams, Category category) {
    @Override
    public String toString() {
        return "TransactionResult{" +
                "carbonEmissionInGrams=" + carbonEmissionInGrams +
                ", category=" + category +
                '}';
    }
}