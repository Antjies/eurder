package com.switchfully.eurder.domain.models;

public class Address {
    private final String streetName;
    private final String number;
    private final String postalCode;
    private final String city;

    public Address(String streetName, String number, String postalCode, String city) {
        this.streetName = streetName;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }
}
