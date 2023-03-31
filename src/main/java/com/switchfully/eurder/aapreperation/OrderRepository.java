package com.switchfully.eurder.aapreperation;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private ConcurrentHashMap<String, Order> orderDatabase;

    public OrderRepository() {
        orderDatabase = new ConcurrentHashMap<>();
    }

    public void addNewOrder(Order order) {
        orderDatabase.put(order.getCustomerId(), order);
    }

    public Collection<Order> getAllOrders(){
        return orderDatabase.values();
    }






}
