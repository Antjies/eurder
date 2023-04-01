package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.ItemGroup;
import com.switchfully.eurder.service.dtos.AllItemGroupDTO;
import com.switchfully.eurder.service.dtos.CreateItemGroupDTO;
import com.switchfully.eurder.service.dtos.ItemGroupDTO;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemGroupMapper {

    public ItemGroup createItemGroupDTOToDomain(CreateItemGroupDTO createItemGroupDTO) {
        return new ItemGroup(createItemGroupDTO.getItemId(), createItemGroupDTO.getAmount());
    }

    public List<ItemGroup> createItemGroupDTOToCollectionDomain(List<CreateItemGroupDTO> createItemGroupDTO) {
        return createItemGroupDTO.stream()
                .map(this::createItemGroupDTOToDomain)
                .collect(Collectors.toList());
    }

    public ItemGroupDTO toItemGroupDTO(ItemGroup itemGroup) {
        return new ItemGroupDTO(itemGroup.getItemId(), itemGroup.getAmount()).setShippingDate(itemGroup.getShippingDate());
    }

    public List<ItemGroupDTO> toItemGroupCollectionDTO(List<ItemGroup> itemGroups){
        return itemGroups.stream()
                .map(this::toItemGroupDTO)
                .collect(Collectors.toList());
    }

    public AllItemGroupDTO toAllItemGroupDTO(ItemGroup itemGroup) {
        return new AllItemGroupDTO()
                .setItemId(itemGroup.getItemId())
                .setAmount(itemGroup.getAmount())
                .setPrice(itemGroup.getCostPerItemGroup()); // already saved when creating ok
        // adding description from somewhere else
    }

    public List<AllItemGroupDTO> toAllItemGroupCollectionDTO(List<ItemGroup> itemGroups){
        return itemGroups.stream()
                .map(this::toAllItemGroupDTO)
                .collect(Collectors.toList());
    }





}
