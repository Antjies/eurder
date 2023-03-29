package com.switchfully.eurder.service.validation;

import com.switchfully.eurder.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AdminValidationAtCreationService {
    @Component
    public class CustomerValidationAtCreationService {

        private UserRepository userRepository;

        @Autowired
        public CustomerValidationAtCreationService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

    }

}
