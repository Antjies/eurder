package com.switchfully.eurder.service.validation;


import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.exception.exceptions.CustomerEmailAddressAlreadyExists;
import com.switchfully.eurder.exception.exceptions.ValidateCustomerInput;
import com.switchfully.eurder.service.dtos.CreateAdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminValidationAtCreationService {

    private UserRepository userRepository;

    @Autowired
    public AdminValidationAtCreationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAdmin(CreateAdminDTO createAdminDTO){
        // authorization
        validateIfEmailExistAlready(createAdminDTO); // bewust afzonderlijk gehouden
        validateAdminInfo(createAdminDTO);
    }

    private void validateIfEmailExistAlready(CreateAdminDTO createAdminDTO) throws CustomerEmailAddressAlreadyExists {
        if (userRepository.getAllCustomers().stream()
                .map(admin -> admin.getEmailAddress())
                .anyMatch(email -> email.equals(createAdminDTO.getEmailAddress()))){
            throw new CustomerEmailAddressAlreadyExists("The email address already exists");
        }
    }

    private void validateAdminInfo(CreateAdminDTO createAdminDTO) {
        boolean controlFactor = false;
        String message = "";

        if (createAdminDTO.getFirstName() == null || createAdminDTO.getFirstName().isBlank()) {
            message += "Please add a first name to register   ";
            controlFactor = true;
        }

        if (createAdminDTO.getLastName() == null || createAdminDTO.getLastName().isBlank()) {
            message += "Please add a last name to register   ";
            controlFactor = true;
        }

        //regex klopt niet 100% -> wordt niet gecontroleerd op .na @
        if (createAdminDTO.getEmailAddress() == null || createAdminDTO.getEmailAddress().isBlank() || !(createAdminDTO.getEmailAddress().matches("^(.+)@(\\S+)$"))) {
            message += "Please add a valid email address   ";
            controlFactor = true;
        }

        if (controlFactor) {
            throw new ValidateCustomerInput(message);
        }
    }




}
