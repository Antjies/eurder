package com.switchfully.eurder.service.validation;


import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.exception.exceptions.CustomerEmailAddressAlreadyExists;
import com.switchfully.eurder.exception.exceptions.ValidateCustomerInput;
import com.switchfully.eurder.service.dtos.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminValidationAtCreationService {

    private UserRepository userRepository;

    @Autowired
    public AdminValidationAtCreationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAdmin(AdminDTO adminDTO){
        // authorization
        validateIfEmailExistAlready(adminDTO); // bewust afzonderlijk gehouden
        validateAdminInfo(adminDTO);
    }

    private void validateIfEmailExistAlready(AdminDTO adminDTO) throws CustomerEmailAddressAlreadyExists {
        if (userRepository.getAllCustomers().stream()
                .map(admin -> admin.getEmailAddress())
                .anyMatch(email -> email.equals(adminDTO.getEmailAddress()))){
            throw new CustomerEmailAddressAlreadyExists("The email address already exists");
        }
    }

    private void validateAdminInfo(AdminDTO adminDTO) {
        boolean controlFactor = false;
        String message = "";

        if (adminDTO.getFirstName() == null || adminDTO.getFirstName().isBlank()) {
            message += "Please add a first name to register   ";
            controlFactor = true;
        }

        if (adminDTO.getLastName() == null || adminDTO.getLastName().isBlank()) {
            message += "Please add a last name to register   ";
            controlFactor = true;
        }

        //regex klopt niet 100% -> wordt niet gecontroleerd op .na @
        if (adminDTO.getEmailAddress() == null || adminDTO.getEmailAddress().isBlank() || !(adminDTO.getEmailAddress().matches("^(.+)@(\\S+)$"))) {
            message += "Please add a valid email address   ";
            controlFactor = true;
        }

        if (controlFactor) {
            throw new ValidateCustomerInput(message);
        }
    }




}
