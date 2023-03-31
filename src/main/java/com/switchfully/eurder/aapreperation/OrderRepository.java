package com.switchfully.eurder.aapreperation;

import com.switchfully.eurder.exception.exceptions.CustomerBoughtNothingException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private ConcurrentHashMap<String, Order> orderDatabase;

    public OrderRepository() {
        orderDatabase = new ConcurrentHashMap<>();
    }

    public void addNewOrder(Order order) {
        orderDatabase.put(order.getCustomerId(), order);
    }

    public Collection<Order> getAllOrdersFromOneCustomerById(String customerId) {
        Collection<Order> ordersFromCust = orderDatabase.values().stream()
                .filter(f -> f.getCustomerId().equals(customerId))
                .collect(Collectors.toList());

        if (ordersFromCust.isEmpty()) {
            throw new CustomerBoughtNothingException("Please buy something first");
        }
        return ordersFromCust;
    }

    public Collection<Order> getAllOrders() {
        return orderDatabase.values();
    }


}
