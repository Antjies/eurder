package com.switchfully.eurder.service.mappers;


import com.switchfully.eurder.domain.models.UserCredentials;
import com.switchfully.eurder.service.dtos.UserCredentialsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCredentialsMapper {
    //UserCredentials -> UserCredentialsDTO
    public UserCredentialsDTO toDTO(UserCredentials userCredentials) {
        return new UserCredentialsDTO(userCredentials.getUsername(), userCredentials.getPassword());
    }

    public UserCredentials toDomain(UserCredentialsDTO userCredentialsDTO){
        return new UserCredentials(userCredentialsDTO.getUsername(), userCredentialsDTO.getPassword());
    }

    //List<UserCredentials> -> List<UserCredentialsDTO>
    public List<UserCredentialsDTO> toDTO(List<UserCredentials> userCredentialsList) {
        return userCredentialsList.stream()
                .map(this::toDTO)
                .toList();
    }
}
