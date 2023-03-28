package com.switchfully.eurder.api;

import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        customerService.registerNewCustomer(createCustomerDTO);
    }



}
