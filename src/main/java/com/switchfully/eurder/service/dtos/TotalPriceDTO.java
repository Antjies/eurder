package com.switchfully.eurder.service.dtos;


import com.switchfully.eurder.domain.models.Currency;

import java.util.List;

public class TotalPriceDTO {

    private String id;
    private String CustomerId;
    private List<ItemGroupDTO> itemGroupList; // no changes allowed once ordered!
    private double priceForTheOrder;
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

    public TotalPriceDTO setPriceForTheOrder(double priceForTheOrder) {
        this.priceForTheOrder = priceForTheOrder;
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

    public double getPriceForTheOrder() {
        return priceForTheOrder;
    }

    public Currency getCurrency() {
        return currency;
    }

}
