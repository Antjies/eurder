package com.switchfully.eurder.aapreperation;

import java.time.LocalDate;

public class CreateItemGroupDTO {

    private final String itemId;
    private final int amount;

    public CreateItemGroupDTO(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

}
