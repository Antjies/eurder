package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.exception.exceptions.CustomerNotFoundException;
import com.switchfully.eurder.exception.exceptions.CustomerEmailAddressAlreadyExists;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private ConcurrentHashMap<String, Customer> customers = new ConcurrentHashMap<>();

    public Customer addCustomer(Customer customer) {
        validateIfEmailExistAlready(customer);
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }

    private void validateIfEmailExistAlready(Customer customer) throws CustomerEmailAddressAlreadyExists {
        if (this.customers.values().stream()
                .map(customers -> customers.getEmailAddress())
                .anyMatch(email -> email.equals(customer.getEmailAddress()))){
            throw new CustomerEmailAddressAlreadyExists("The email address already exists");
        }
    }

    public Customer getCustomerById(String id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " doesn't exist.");
        }
        return customer;
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
