package com.creditcarbon.creditcarbonbackend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionResult(double carbonEmissionInGrams, double carbonEmissionInOunces, Category category) {
    @Override
    public String toString() {
        return "TransactionResult{" +
                "carbonEmissionInGrams=" + carbonEmissionInGrams +
                ", carbonEmissionInOunces=" + carbonEmissionInOunces +
                ", category=" + category +
                '}';
    }
}

;