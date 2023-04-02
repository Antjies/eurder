package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Admin;
import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.domain.models.User;
import com.switchfully.eurder.exception.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@DependsOn("userCredentialsRepository")
public class UserRepository {


    private final UserCredentialsRepository userCredentialsRepository;

    private ConcurrentHashMap<String, User> userDatabase;

    @Autowired
    public UserRepository(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
        userDatabase = new ConcurrentHashMap<>();
        initializeDummyDatabase();
    }

    public void addCustomer(Customer customer) {
        userDatabase.put(customer.getId(), customer);
    }

    public void addAdmin(Admin admin) {
        userDatabase.put(admin.getId(), admin);
    }

    public Customer getCustomerById(String id) {
        //check what happens when you try to get admin id?
        return userDatabase.values().stream()
                .filter(user -> user.getId().equals(id))
                .filter(user -> user.getClass() == Customer.class)
                .map(user -> (Customer) user)
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " doesn't exist."));
    }

    public Collection<Customer> getAllCustomers() {
        return userDatabase.values().stream()
                .filter(user -> user.getClass() == Customer.class)
                .map(user ->(Customer) user)
                .toList();
    }

    public Collection<Admin> getAllAdmins() {
        return userDatabase.values().stream()
                .filter(user -> user.getClass() == Admin.class)
                .map(user ->(Admin) user)
                .toList();
    }

    private void initializeDummyDatabase() {
        Admin admin = new Admin("AdminFn", "AdminLn", "admin@admin.com");
        userDatabase.put(admin.getId(), admin);
        userCredentialsRepository.createCredentials("Basic YWRtaW46cHdk", admin);
    }
}
