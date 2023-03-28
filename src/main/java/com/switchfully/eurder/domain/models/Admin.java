package com.switchfully.eurder.domain.models;

import java.util.List;

public class Admin extends User{

    public Admin(String firstName, String lastName, String emailAddress) {
        super(firstName, lastName, emailAddress);
        //featureList = List.of(Feature.CAN_SEE_ALL_MEMBERS, Feature.CAN_CREATE_ADMIN,
        //        Feature.CAN_CREATE_LIBRARIAN);
    }
}
