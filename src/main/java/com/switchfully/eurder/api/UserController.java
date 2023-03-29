package com.switchfully.eurder.api;

import com.switchfully.eurder.service.UserService;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;
    private final Logger myLogger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", value = "customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        myLogger.info("Handler method registerNewCustomer is called");
        userService.registerNewCustomer(createCustomerDTO);
    }

    @GetMapping(produces = "application/json", value = "customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO showCustomerById(@PathVariable String id) {
        // ADMIN AUTHORIZATION
        return userService.getCustomerById(id);
    }

    @GetMapping(produces = "application/json", value = "customers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CustomerDTO> getAllCustomers(){
        // ADMin AUTHORIZATION
        return userService.getAllCustomers();
    }



}
