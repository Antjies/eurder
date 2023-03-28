package com.switchfully.eurder.service.dtos;

import com.switchfully.eurder.domain.models.Address;

public class CustomerDTO{
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private AddressDTO addressDTO;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public CustomerDTO setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
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
