package com.switchfully.eurder.service.dtos;

public class AllItemGroupDTO {

    private String itemId;
    private String description;
    private int amount;
    private double price;

    public String getItemId() {
        return itemId;
    }

    public AllItemGroupDTO setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AllItemGroupDTO setDescription(String description) {
        this.description = description;
        return this;
    }


    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public AllItemGroupDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public AllItemGroupDTO setPrice(double price) {
        this.price = price;
        return this;
    }
}
