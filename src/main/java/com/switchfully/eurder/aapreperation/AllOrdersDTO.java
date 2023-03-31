package com.switchfully.eurder.aapreperation;

import java.util.List;

public class AllOrdersDTO {

    private String customerId;
    private double totalPriceAllOrders;
    private List<OrderDTO> allOrdersOfCustomer;

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalPriceAllOrders() {
        return totalPriceAllOrders;
    }

    public List<OrderDTO> getAllOrdersOfCustomer() {
        return allOrdersOfCustomer;
    }
}
