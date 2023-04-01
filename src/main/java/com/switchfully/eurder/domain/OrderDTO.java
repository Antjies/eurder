package com.switchfully.eurder.domain;

import com.switchfully.eurder.service.dtos.AllItemGroupDTO;

import java.util.List;

public class OrderDTO {

    private String id;
    private String CustomerId;
    private List<AllItemGroupDTO> itemGroupList;
    private double priceForTheOrder;

    public OrderDTO setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDTO setCustomerId(String customerId) {
        CustomerId = customerId;
        return this;
    }

    public OrderDTO setItemGroupList(List<AllItemGroupDTO> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public OrderDTO setPriceForTheOrder(double priceForTheOrder) {
        this.priceForTheOrder = priceForTheOrder;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public List<AllItemGroupDTO> getItemGroupList() {
        return itemGroupList;
    }

    public double getPriceForTheOrder() {
        return priceForTheOrder;
    }
}
