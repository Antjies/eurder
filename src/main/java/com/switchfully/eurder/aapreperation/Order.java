package com.switchfully.eurder.aapreperation;

import java.util.List;

public class Order {

    private final String id;
    private final String CustomerId;
    private List<ItemGroup> itemGroupList;

    public Order(String id, String customerId, List<ItemGroup> itemGroupList) {
        this.id = id;
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
}
