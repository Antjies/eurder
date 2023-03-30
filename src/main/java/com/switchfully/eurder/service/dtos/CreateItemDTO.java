package com.switchfully.eurder.service.dtos;

import com.switchfully.eurder.domain.models.Price;


public class CreateItemDTO {
    private String name;
    private String description;
    private PriceDTO price;
    private int amountInStock;

    public CreateItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateItemDTO setPrice(PriceDTO price) {
        this.price = price;
        return this;
    }

    public PriceDTO getPrice() {
        return price;
    }

    public CreateItemDTO setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
