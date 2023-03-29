package com.switchfully.eurder.domain.repositories;


import com.switchfully.eurder.domain.models.User;
import com.switchfully.eurder.domain.models.UserCredentials;
import org.springframework.stereotype.Repository;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserCredentialsRepository {

    private final Map<UserCredentials, User> userCredentialsDatabase;

    public UserCredentialsRepository() {
        userCredentialsDatabase = new HashMap<>();
    }

    public UserCredentials getUserCredentials(String username) {
        return userCredentialsDatabase.keySet()
                .stream()
                .filter(credentials -> credentials.getUsername().equals(username))
                .findFirst()
                .get();
    }

    public User getUser(String username) {
        return userCredentialsDatabase
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().getUsername().equals(username))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    public void createCredentials(String authorization, User user) {
        UserCredentials userCredentials = getUsernamePassword(authorization);
        userCredentialsDatabase.put(userCredentials, user);
    }

    public void addCredentials(UserCredentials userCredentials, User user) {
        userCredentialsDatabase.put(userCredentials, user);
    }

    private UserCredentials getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UserCredentials(username, password);
    }
}
