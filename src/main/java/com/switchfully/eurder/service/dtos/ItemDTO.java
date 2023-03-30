package com.switchfully.eurder.service.dtos;


public class ItemDTO {
    private String id;
    private String name;
    private String description;
    private PriceDTO price;
    private int amountInStock;

    public ItemDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public ItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDTO setPrice(PriceDTO price) {
        this.price = price;
        return this;
    }

    public PriceDTO getPrice() {
        return price;
    }

    public ItemDTO setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
