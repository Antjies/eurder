package com.switchfully.eurder.service.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreateCustomerDTO {
    @NotNull
    @NotEmpty
    private String firstName;
    private String lastName;
    private String emailAddress;
    private AddressDTO address;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public CreateCustomerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateCustomerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public CreateCustomerDTO setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public CreateCustomerDTO setAddress(AddressDTO address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CreateCustomerDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
