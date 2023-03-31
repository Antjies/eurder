package com.switchfully.eurder.aapreperation;

import com.switchfully.eurder.aapreperation.OrderRepository;
import com.switchfully.eurder.aapreperation.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }
}
