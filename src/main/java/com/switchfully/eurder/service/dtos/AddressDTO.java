package com.switchfully.eurder.service.dtos;

public class AddressDTO{

    //@NotNull
    //@NotEmpty
    private String streetName;
    private String number;
    private String postalCode;
    private String city;

    public AddressDTO setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public AddressDTO setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressDTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCity() {
        return city;
    }
}
