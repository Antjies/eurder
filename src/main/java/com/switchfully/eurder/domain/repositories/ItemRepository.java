package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Item;
import com.switchfully.eurder.exception.exceptions.CustomerNotFoundException;
import com.switchfully.eurder.exception.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private ConcurrentHashMap<String, Item> itemDatabase;

    public ItemRepository() {
        itemDatabase = new ConcurrentHashMap<>();
    }

    public void addNewItem(Item newItem) {
        itemDatabase.put(newItem.getId(), newItem);
    }

    public void changeAmountInItemRepository(String itemId, int amount){
        Item changeItemAmount = getItemById(itemId);
        changeItemAmount.setAmountInStock(changeItemAmount.getAmountInStock() - amount);
        itemDatabase.replace(changeItemAmount.getId(), changeItemAmount);
    }

    public Collection<Item> getAllItems(){
        return itemDatabase.values();
    }

    public Item getItemById(String itemId) {
        return itemDatabase.values().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with item " + itemId + " doesn't exist."));
    }
}
