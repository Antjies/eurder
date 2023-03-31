package com.switchfully.eurder.aapreperation;

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





}
