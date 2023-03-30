package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.models.Feature;
import com.switchfully.eurder.service.UserService;
import com.switchfully.eurder.service.dtos.AdminDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import com.switchfully.eurder.service.SecurityService;
import com.switchfully.eurder.service.wrappers.AdminWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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


    //Creating a new Customer
    @PostMapping(consumes = "application/json", value = "customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        myLogger.info("Handler method registerNewCustomer is called");
        userService.registerNewCustomer(createCustomerDTO);
    }


    //Everything about Getting information about customers. Authorization needed
    @GetMapping(produces = "application/json", value = "customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public CustomerDTO showCustomerById(@PathVariable String id, @RequestHeader String authorization) {
        myLogger.info("Handler method showCustomerById is called");
        securityService.validateAuthorization(authorization, Feature.CAN_SEE_ALL_CUSTOMERS);
        return userService.getCustomerById(id);
    }

    @GetMapping(produces = "application/json", value = "customers")
    @ResponseStatus(HttpStatus.OK)
    @Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public Collection<CustomerDTO> getAllCustomers(@RequestHeader String authorization){
        myLogger.info("Handler method getAllCustomers is called");
        securityService.validateAuthorization(authorization, Feature.CAN_SEE_ALL_CUSTOMERS);
        return userService.getAllCustomers();
    }


    //Everything about Admin creating and getting information
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", value = "admins")
    @Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public void createAdminWithRequestWrapper(@RequestBody AdminWrapper adminWrapper, @RequestHeader String authorization){
        myLogger.info("Handler method createAdminWithRequestWrapper is called");
        securityService.validateAuthorization(authorization, Feature.CAN_CREATE_ADMIN);
        userService.createAdminWithRequestWrapper(adminWrapper);
    }

    @GetMapping(produces = "application/json", value = "admins")
    @ResponseStatus(HttpStatus.OK)
    @Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public Collection<AdminDTO> getAllAdmins(@RequestHeader String authorization){
        myLogger.info("Handler method getAllAdmins is called");
        securityService.validateAuthorization(authorization, Feature.CAN_SEE_ALL_ADMINS);
        return userService.getAllAdmins();
    }



}
