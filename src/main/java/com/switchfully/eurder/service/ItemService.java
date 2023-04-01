package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Currency;
import com.switchfully.eurder.domain.models.Item;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.exception.exceptions.ValidateItemInput;
import com.switchfully.eurder.service.dtos.CreateItemDTO;
import com.switchfully.eurder.service.dtos.ItemDTO;
import com.switchfully.eurder.service.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    public void addNewItem(CreateItemDTO createItemDTO) {
        validateItemDTO(createItemDTO);
        Item newItem = itemMapper.toDomain(createItemDTO);
        itemRepository.addNewItem(newItem);
    }

    public Collection<ItemDTO> getAllItems() {
        return itemMapper.toCollectionDTO(itemRepository.getAllItems());
    }

    private void validateItemDTO(CreateItemDTO createItemDTO){
        boolean controlFactor = false;
        String message = "";

        // control double items checkers? no!

        if (createItemDTO.getName() == null || createItemDTO.getName().isBlank()) {
            message += "Please add the items name   ";
            controlFactor = true;
        }

        if (createItemDTO.getDescription() == null || createItemDTO.getDescription().isBlank()) {
            message += "Please add the items description   ";
            controlFactor = true;
        }

        if (createItemDTO.getPrice().getAmount() <= 0.0) {
            message += "Please add an amount greater then 0.0   ";
            controlFactor = true;
        }

        // I don't check the Enum but it gives its own error with clear message
        // eerst string maken in DTO en dan omzetten naar ENUM
        // JSON parse error: Cannot coerce empty String ("") to `com.switchfully.eurder.domain.models.Currency` value (but could if coercion was enabled using `CoercionConfig`)]

        if (controlFactor) {
            throw new ValidateItemInput(message);
        }
    }


    public ItemDTO updateItemById(String id, ItemDTO newItem) {
        Item oldItem = itemRepository.getItemById(id); // check if id exists!
        validateItemDTOForUpdate(newItem, id);// check input validation
        itemRepository.updateItemById(oldItem, newItem);
        return itemMapper.toItemDTO(itemRepository.getItemById(id)); // haalt info op van database en zet om naar ItemDTO voor Controller!
    }

    private void validateItemDTOForUpdate(ItemDTO itemDTO, String id){
        boolean controlFactor = false;
        String message = "";

        if (!itemDTO.getId().equals(id)){
            message += "The ID can't change!! so please add the same id or don't move on...   ";
            controlFactor = true;
        }

        if (itemDTO.getName() == null || itemDTO.getName().isBlank()) {
            message += "Please add the items name   ";
            controlFactor = true;
        }

        if (itemDTO.getDescription() == null || itemDTO.getDescription().isBlank()) {
            message += "Please add the items description   ";
            controlFactor = true;
        }

        if (itemDTO.getPrice().getAmount() <= 0.0) {
            message += "Please add an amount greater then 0.0   ";
            controlFactor = true;
        }

        // I don't check the Enum but it gives its own error with clear message
        // eerst string maken in DTO en dan omzetten naar ENUM
        // JSON parse error: Cannot coerce empty String ("") to `com.switchfully.eurder.domain.models.Currency` value (but could if coercion was enabled using `CoercionConfig`)]

        if (controlFactor) {
            throw new ValidateItemInput(message);
        }
    }



}
