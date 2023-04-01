package com.switchfully.eurder.domain.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {

    @Test
    public void testConstructorAndGetters() {
        String customerId = "123";
        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(new ItemGroup("itemid", 5));

        Order order = new Order(customerId, itemGroupList);

        assertNotNull(order.getId());
        assertEquals(customerId, order.getCustomerId());
        assertEquals(itemGroupList, order.getItemGroupList());
    }
}
