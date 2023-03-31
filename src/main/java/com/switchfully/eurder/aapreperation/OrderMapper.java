package com.switchfully.eurder.aapreperation;

import com.switchfully.eurder.domain.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public TotalPriceDTO toDTO(Order order) {
        return new TotalPriceDTO()
                .setId(order.getId())
                .setCustomerId(order.getCustomerId())
                .setItemGroupList(itemGroupMapper.toItemGroupCollectionDTO(order.getItemGroupList()))
                .setPrice(order.getCost())
                .setCurrency(Currency.Euro);
    }
}
