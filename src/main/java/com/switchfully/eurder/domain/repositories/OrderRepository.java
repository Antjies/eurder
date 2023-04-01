package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Order;
import com.switchfully.eurder.exception.exceptions.CustomerBoughtNothingException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private ConcurrentHashMap<String, Order> orderDatabase;

    public OrderRepository() {
        orderDatabase = new ConcurrentHashMap<>();
    }

    public void addNewOrder(Order order) {
        orderDatabase.put(order.getId(), order);
    }

    public List<Order> getAllOrdersFromOneCustomerById(String customerId) {
        List<Order> ordersFromCust = orderDatabase.values().stream()
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
