package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.exception.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private ConcurrentHashMap<String, Customer> customers = new ConcurrentHashMap<>();

    public Customer addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }


    public Customer getCustomerById(String id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " doesn't exist.");
        }
        return customer;
    }
}
