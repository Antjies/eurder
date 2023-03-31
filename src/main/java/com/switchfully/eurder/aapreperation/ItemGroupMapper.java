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

    public AllItemGroupDTO toAllItemGroupDTO(AllItemGroupDTO itemGroup) {
        return new AllItemGroupDTO()
                .setItemId(itemGroup.getItemId())
                .setDescription(itemGroup.getDescription())

    }

    public List<AllItemGroupDTO> toAllItemGroupCollectionDTO(List<AllItemGroupDTO> itemGroups){
        return itemGroups.stream()
                .map(this::toAllItemGroupDTO)
                .collect(Collectors.toList());
    }





}
