package com.switchfully.eurder.domain.models;

import java.util.UUID;

public class Item {
    private String id;
    private String name;
    private String description;
    private Price price;
    private int amountInStock;

    public Item(String name, String description, Price price, int amountInStock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
