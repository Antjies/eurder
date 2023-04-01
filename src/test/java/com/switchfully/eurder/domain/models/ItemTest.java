package com.switchfully.eurder.domain.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ItemTest {

    @Test
    public void testConstructorAndGetters() {
        String name = "Test Item";
        String description = "This is a test item";
        Price price = new Price(10.0, Currency.Euro);
        int amountInStock = 5;

        Item item = new Item(name, description, price, amountInStock);

        assertNotNull(item.getId());
        assertEquals(name, item.getName());
        assertEquals(description, item.getDescription());
        assertEquals(price, item.getPrice());
        assertEquals(amountInStock, item.getAmountInStock());
    }
}
