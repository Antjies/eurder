package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private ConcurrentHashMap<String, Customer> customers = new ConcurrentHashMap<>();

    public Customer addCustomer(Customer customer){
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }




}
