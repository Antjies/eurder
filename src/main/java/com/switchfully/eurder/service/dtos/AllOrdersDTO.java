package com.switchfully.eurder.service.dtos;

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

    public AllOrdersDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public AllOrdersDTO setTotalPriceAllOrders(double totalPriceAllOrders) {
        this.totalPriceAllOrders = totalPriceAllOrders;
        return this;
    }

    public AllOrdersDTO setAllOrdersOfCustomer(List<OrderDTO> allOrdersOfCustomer) {
        this.allOrdersOfCustomer = allOrdersOfCustomer;
        return this;
    }
}
