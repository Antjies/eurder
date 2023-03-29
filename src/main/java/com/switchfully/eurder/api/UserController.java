package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.models.Feature;
import com.switchfully.eurder.service.UserService;
import com.switchfully.eurder.service.dtos.AdminDTO;
import com.switchfully.eurder.service.dtos.CreateAdminDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import com.switchfully.eurder.service.SecurityService;
import com.switchfully.eurder.service.wrappers.AdminWrapper;
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
    private final SecurityService securityService;
    private final Logger myLogger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
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
        myLogger.info("Handler method showCustomerById is called");
        //securityService.validateAuthorization(authorization, Feature.CAN_SEE_ALL_CUSTOMERS);
        return userService.getCustomerById(id);
    }

    @GetMapping(produces = "application/json", value = "customers")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CustomerDTO> getAllCustomers(){
        myLogger.info("Handler method getAllCustomers is called");
        //securityService.validateAuthorization(authorization, Feature.CAN_SEE_ALL_CUSTOMERS);
        return userService.getAllCustomers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", value = "admins")
    public void createAdminWithRequestWrapper(@RequestBody AdminWrapper adminWrapper, @RequestHeader String authorization){
        myLogger.info("Handler method createAdminWithRequestWrapper is called");
        securityService.validateAuthorization(authorization, Feature.CAN_CREATE_ADMIN);
        userService.createAdminWithRequestWrapper(adminWrapper);
    }

    @GetMapping(produces = "application/json", value = "admins")
    @ResponseStatus(HttpStatus.OK)
    public Collection<AdminDTO> getAllAdmins(@RequestHeader String authorization){
        myLogger.info("Handler method getAllAdmins is called");
        securityService.validateAuthorization(authorization, Feature.CAN_SEE_ALL_ADMINS);
        return userService.getAllAdmins();
    }



}
