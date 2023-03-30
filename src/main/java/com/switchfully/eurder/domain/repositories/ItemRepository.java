package com.switchfully.eurder.domain.repositories;

import com.switchfully.eurder.domain.models.Item;
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

    public Collection<Item> getAllItems(){
        return itemDatabase.values();
    }
}
