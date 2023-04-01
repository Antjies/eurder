package com.switchfully.eurder.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PriceTest {

    @Test
    public void testConstructorAndGetters() {
        double amount = 10.0;
        Currency currency = Currency.Euro;

        Price price = new Price(amount, currency);

        assertEquals(amount, price.getAmount());
        assertEquals(currency, price.getCurrency());
    }
}
