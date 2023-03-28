package com.switchfully.eurder.api;

import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;
    private final Logger myLogger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        myLogger.info("Handler method registerNewCustomer is called");
        // CONTROL ABOUT WHAT IS FILLED IN(EMAIL, ADDRESS,...) IS NEEDED AND EXCEPTIONS
        customerService.registerNewCustomer(createCustomerDTO);
    }

    @GetMapping(produces = "application/json", value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO showDetailsOfBook(@PathVariable String id) {
        // ADMIN AUTHORIZATION
        return customerService.getCustomerById(id);
    }



}
