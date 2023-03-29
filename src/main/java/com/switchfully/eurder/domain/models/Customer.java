package com.switchfully.eurder.domain.models;

import java.util.List;

public class Customer extends User{
    private final Address address;
    private String phoneNumber;

    public Customer(String firstName, String lastName, String emailAddress, Address address, String phoneNumber) {
        super(firstName, lastName, emailAddress);
        featureList = List.of(Feature.CAN_REGISTER, Feature.CAN_ORDER_ITEMS);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
