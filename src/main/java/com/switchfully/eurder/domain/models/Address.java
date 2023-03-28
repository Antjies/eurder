package com.switchfully.eurder.domain.models;

//**immutable**object!!
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

    public String getStreetName() {
        return streetName;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
