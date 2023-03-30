package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.Item;
import com.switchfully.eurder.service.dtos.CreateItemDTO;
import com.switchfully.eurder.service.dtos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    private final PriceMapper priceMapper;

    @Autowired
    public ItemMapper(PriceMapper priceMapper) {
        this.priceMapper = priceMapper;
    }


    public Item toDomain(CreateItemDTO createItemDTO) {
        return new Item(createItemDTO.getName(), createItemDTO.getDescription(), priceMapper.toDomain(createItemDTO.getPrice()), createItemDTO.getAmountInStock());
    }

    public CreateItemDTO toDTO(Item item){
        return new CreateItemDTO()
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(priceMapper.toDTO(item.getPrice()))
                .setAmountInStock(item.getAmountInStock());
    }

    public Collection<CreateItemDTO> toCollectionDTO(Collection<Item> allItems){
        return allItems.stream()
                .map(f -> toDTO(f))
                .collect(Collectors.toList());
    }


}
