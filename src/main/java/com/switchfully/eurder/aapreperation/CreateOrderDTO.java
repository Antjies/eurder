package com.switchfully.eurder.aapreperation;

import java.util.List;

public class CreateOrderDTO {

    private String CustomerId;
    private List<CreateItemGroupDTO> itemGroupList; // no changes allowed once ordered!

    public CreateOrderDTO setCustomerId(String customerId) {
        CustomerId = customerId;
        return this;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public CreateOrderDTO setItemGroupList(List<CreateItemGroupDTO> itemGroupList) {
        this.itemGroupList = itemGroupList;
        return this;
    }

    public List<CreateItemGroupDTO> getItemGroupList() {
        return itemGroupList;
    }
}
