package com.switchfully.eurder.service.wrappers;


import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.UserCredentialsDTO;

public class CustomerWrapper {
    private final CreateCustomerDTO user;
    private final UserCredentialsDTO userCredentials;

    public CustomerWrapper(CreateCustomerDTO user, UserCredentialsDTO userCredentials){
        this.user = user;
        this.userCredentials = userCredentials;
    }

    public CreateCustomerDTO getUser(){
        return user;
    }

    public UserCredentialsDTO getUserCredentials(){
        return userCredentials;
    }
}
