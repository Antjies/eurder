package com.switchfully.eurder.domain.models;

import java.util.UUID;

public abstract class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private String emailAddress;
    private Address address;
    private String phoneNumber;

    public User(String firstName, String lastName, String emailAddress, Address address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
