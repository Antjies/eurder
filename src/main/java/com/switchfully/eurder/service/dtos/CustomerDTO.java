package com.switchfully.eurder.service.dtos;

public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private AddressDTO address;
    private String phoneNumber;

    public String getId() {
        return id;
    }

    public CustomerDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public CustomerDTO setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public CustomerDTO setAddress(AddressDTO address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}


