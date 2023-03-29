package com.switchfully.eurder.service;


import com.switchfully.eurder.domain.models.Feature;
import com.switchfully.eurder.domain.models.User;
import com.switchfully.eurder.domain.models.UserCredentials;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.exception.exceptions.UnauthorizedAccessException;
import com.switchfully.eurder.service.dtos.UserCredentialsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;

import static java.lang.String.format;

@Service
public class SecurityService {
    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    private final UserCredentialsRepository userCredentialsRepository;

    public SecurityService(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    public void validateAuthorization(String authorization, Feature feature) {
        UserCredentialsDTO usernamePassword = getUsernamePassword(authorization);
        UserCredentials userCredentials = userCredentialsRepository.getUserCredentials(usernamePassword.getUsername());
        User user = userCredentialsRepository.getUser(userCredentials.getUsername());

        if (!userCredentials.doesPasswordMatch(usernamePassword.getPassword())) {
            logger.error(format("Password does not match for user %s", usernamePassword.getUsername()));
            throw new UnauthorizedAccessException(format("Password does not match for user %s", usernamePassword.getUsername()));
        }
        if (!user.canHaveAccessTo(feature)) {
            logger.error(format("User %s does not have access to %s", usernamePassword.getUsername(), feature));
            throw new UnauthorizedAccessException(format("User %s does not have access to %s", usernamePassword.getUsername(), feature));
        }
    }

    private UserCredentialsDTO getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UserCredentialsDTO(username, password);
    }
}
