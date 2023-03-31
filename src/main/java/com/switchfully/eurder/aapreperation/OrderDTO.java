package com.switchfully.eurder.aapreperation;

import java.util.List;
import java.util.UUID;

public class OrderDTO {

    private final String id;
    private final String CustomerId;
    private final List<ItemGroupDTO> itemGroupList; // no changes allowed once ordered!

    public OrderDTO(String customerId, List<ItemGroupDTO> itemGroupList) {
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

    public List<ItemGroupDTO> getItemGroupList() {
        return itemGroupList;
    }
}
