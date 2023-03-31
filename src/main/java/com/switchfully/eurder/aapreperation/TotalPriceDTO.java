package com.switchfully.eurder.aapreperation;


import com.switchfully.eurder.domain.models.Currency;

import java.util.List;

public class TotalPriceDTO {

    private String id;
    private String CustomerId;
    private List<ItemGroupDTO> itemGroupList; // no changes allowed once ordered!
    private double price;
    private Currency currency;

    public TotalPriceDTO setId(String id) {
        this.id = id;
        return this;
    }

    public TotalPriceDTO setCustomerId(String customerId) {
        CustomerId = customerId;
        return this;
    }

    public TotalPriceDTO setItemGroupList(List<ItemGroupDTO> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public TotalPriceDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public TotalPriceDTO setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public List<ItemGroupDTO> getItemGroupList() {
        return itemGroupList;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

}
