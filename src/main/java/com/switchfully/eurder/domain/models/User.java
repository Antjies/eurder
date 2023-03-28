package com.switchfully.eurder.domain.models;

import java.util.UUID;

public abstract class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private String emailAddress;
    //List<Feature> featureList;

    public User(String firstName, String lastName, String emailAddress) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
