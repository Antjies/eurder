package com.switchfully.eurder.service.dtos;

public class AdminDTO {
    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    public AdminDTO(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
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
