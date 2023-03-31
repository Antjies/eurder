package com.switchfully.eurder.aapreperation;

import java.util.List;
import java.util.UUID;

public class Order {

    private final String id;
    private final String CustomerId;
    private final List<ItemGroup> itemGroupList; // no changes allowed once ordered!
    private double cost;

    public Order(String customerId, List<ItemGroup> itemGroupList) {
        this.id = UUID.randomUUID().toString();
        CustomerId = customerId;
        this.itemGroupList = itemGroupList;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Order setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public double getCost() {
        return cost;
    }
}



