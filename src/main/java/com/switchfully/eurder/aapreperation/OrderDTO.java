package com.switchfully.eurder.aapreperation;

import java.util.List;

public class OrderDTO {

    private String id;
    private String CustomerId;
    private List<ItemGroupDTO> itemGroupList;
    private double priceForTheOrder;

    public OrderDTO setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDTO setCustomerId(String customerId) {
        CustomerId = customerId;
        return this;
    }

    public OrderDTO setItemGroupList(List<ItemGroupDTO> itemGroupList) {
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

    public List<ItemGroupDTO> getItemGroupList() {
        return itemGroupList;
    }

    public double getPriceForTheOrder() {
        return priceForTheOrder;
    }
}
