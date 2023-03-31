package com.switchfully.eurder.aapreperation;

import java.time.LocalDate;

public class ItemGroup {

    private final String itemId;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    //Logic itself happens in Service itself. Then it just adds the correct date to it...
    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
