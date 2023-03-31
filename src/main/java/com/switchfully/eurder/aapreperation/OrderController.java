package com.switchfully.eurder.aapreperation;

import com.switchfully.eurder.api.UserController;
import com.switchfully.eurder.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "orders")
public class OrderController {

    private final OrderService orderService;
    private final SecurityService securityService;
    private final Logger myLogger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    //Customer can create an order
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    //@Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public TotalPriceDTO orderItems(@RequestBody CreateOrderDTO createOrderDTO /*, @RequestHeader String authorization*/) {
        myLogger.info("Handler method orderItems is called");
        //securityService.validateAuthorization(authorization, Feature.CAN_ORDER_ITEMS); //no security yet for customers
        return orderService.orderItems(createOrderDTO);
    }


    //Customer can view all his orders
    @GetMapping(produces = "application/json", value = "customers")
    @ResponseStatus(HttpStatus.OK)
    //@Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public AllOrdersDTO getAllOrdersFromOneCustomerById(@RequestParam String customerId/*@RequestHeader String authorization*/) {
        myLogger.info("Handler method getAllOrdersFromOneCustomerById is called");
        //securityService.validateAuthorization(authorization, Feature.CAN_ORDER_ITEMS); //no security yet for customers
        return orderService.getAllOrdersFromOneCustomerById(customerId);
    }





}
