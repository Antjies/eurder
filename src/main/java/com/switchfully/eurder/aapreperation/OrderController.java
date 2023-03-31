package com.switchfully.eurder.aapreperation;

import com.switchfully.eurder.api.UserController;
import com.switchfully.eurder.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
