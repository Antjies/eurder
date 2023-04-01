package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.OrderDTO;
import com.switchfully.eurder.domain.models.Currency;
import com.switchfully.eurder.domain.models.Order;
import com.switchfully.eurder.service.dtos.CreateOrderDTO;
import com.switchfully.eurder.service.dtos.TotalPriceDTO;
import com.switchfully.eurder.service.mappers.ItemGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final ItemGroupMapper itemGroupMapper;

    @Autowired
    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public Order createOrderDTOToDomain(CreateOrderDTO createOrderDTO) {
        return new Order(createOrderDTO.getCustomerId(), itemGroupMapper.createItemGroupDTOToCollectionDomain(createOrderDTO.getItemGroupList()));
    }

    public List<OrderDTO> toOrderDTOList(List<Order> orders){
        return orders.stream()
                .map(f -> toOrderDTO(f))
                .collect(Collectors.toList());
    }

    public OrderDTO toOrderDTO(Order order){
        return new OrderDTO()
                .setId(order.getId())
                .setCustomerId(order.getCustomerId())
                .setItemGroupList(itemGroupMapper.toAllItemGroupCollectionDTO(order.getItemGroupList()))
                .setPriceForTheOrder(order.getPriceForTheOrder()); // cost should already be saved when ordering ok

    }

    public TotalPriceDTO toDTO(Order order) {
        return new TotalPriceDTO()
                .setId(order.getId())
                .setCustomerId(order.getCustomerId())
                .setItemGroupList(itemGroupMapper.toItemGroupCollectionDTO(order.getItemGroupList()))
                .setPriceForTheOrder(order.getPriceForTheOrder())
                .setCurrency(Currency.Euro);
    }
}
