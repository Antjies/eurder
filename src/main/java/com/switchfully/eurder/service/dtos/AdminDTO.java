package com.switchfully.eurder.service.dtos;

public class AdminDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public AdminDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public AdminDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AdminDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public AdminDTO setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
}
