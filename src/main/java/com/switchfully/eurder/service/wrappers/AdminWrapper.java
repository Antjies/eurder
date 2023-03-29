package com.switchfully.eurder.service.wrappers;

import com.switchfully.eurder.service.dtos.CreateAdminDTO;
import com.switchfully.eurder.service.dtos.UserCredentialsDTO;

public class AdminWrapper {
    private final CreateAdminDTO user;
    private final UserCredentialsDTO userCredentials;

    public AdminWrapper(CreateAdminDTO user, UserCredentialsDTO userCredentials){
        this.user = user;
        this.userCredentials = userCredentials;
    }

    public CreateAdminDTO getUser(){
        return user;
    }

    public UserCredentialsDTO getUserCredentials(){
        return userCredentials;
    }
}
