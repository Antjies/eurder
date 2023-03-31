package com.switchfully.eurder.aapreperation;

import java.time.LocalDate;

public class AllItemGroupDTO {

    private String itemId;
    private String description;
    private int amount;
    private LocalDate shippingDate;
    private double price;


    public String getDescription() {
        return description;
    }

    public AllItemGroupDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getPrice() {
        return price;
    }

    public AllItemGroupDTO setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public AllItemGroupDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public AllItemGroupDTO setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public AllItemGroupDTO setPrice(double price) {
        this.price = price;
        return this;
    }
}
