package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.domain.models.User;
import com.switchfully.eurder.exception.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<String, User> customers = new ConcurrentHashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomerById(String id) {
        return customers.values().stream()
                .filter(user -> user.getId().equals(id))
                .filter(user -> user.getClass() == Customer.class)
                .map(user -> (Customer) user)
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " doesn't exist."));


        /*User customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " doesn't exist.");
        }
        return customer;*/
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values().stream()
                .filter(user -> user.getClass() == Customer.class)
                .map(user ->(Customer) user)
                .toList();
    }
}
