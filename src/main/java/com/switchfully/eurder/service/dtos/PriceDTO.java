package com.switchfully.eurder.service.dtos;


import com.switchfully.eurder.domain.models.Currency;

public class PriceDTO {

    private final double amount;
    private final Currency currency;

    public PriceDTO(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
