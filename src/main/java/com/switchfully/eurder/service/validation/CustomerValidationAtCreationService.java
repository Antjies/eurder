package com.switchfully.eurder.service.validation;

import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.exception.exceptions.CustomerEmailAddressAlreadyExists;
import com.switchfully.eurder.exception.exceptions.ValidateCustomerInput;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerValidationAtCreationService {

    private UserRepository userRepository;

    @Autowired
    public CustomerValidationAtCreationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateCustomer(CreateCustomerDTO createCustomerDTO){
        validateIfEmailExistAlready(createCustomerDTO); // bewust afzonderlijk gehouden
        validateCustomerDTO(createCustomerDTO);
    }

    private void validateIfEmailExistAlready(CreateCustomerDTO createCustomerDTO) throws CustomerEmailAddressAlreadyExists {
        if (userRepository.getAllCustomers().stream()
                .map(customers -> customers.getEmailAddress())
                .anyMatch(email -> email.equals(createCustomerDTO.getEmailAddress()))){
            throw new CustomerEmailAddressAlreadyExists("The email address already exists");
        }
    }

    private void validateCustomerDTO(CreateCustomerDTO createCustomerDTO){
        boolean controlFactor = false;
        String message = "";

        if (createCustomerDTO.getFirstName() == null || createCustomerDTO.getFirstName().isBlank()) {
            message += "Please add a first name to register   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getLastName() == null || createCustomerDTO.getLastName().isBlank()) {
            message += "Please add a last name to register   ";
            controlFactor = true;
        }

        //regex klopt niet 100% -> wordt niet gecontroleerd op .na @
        if (createCustomerDTO.getEmailAddress() == null || createCustomerDTO.getEmailAddress().isBlank() || !(createCustomerDTO.getEmailAddress().matches("^(.+)@(\\S+)$"))) {
            message += "Please add a valid email address   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getPhoneNumber() == null || createCustomerDTO.getPhoneNumber().isBlank() || !(createCustomerDTO.getPhoneNumber().matches("^(((\\+|00)32[ ]?(?:\\(0\\)[ ]?)?)|0){1}(4(60|[789]\\d)\\/?(\\s?\\d{2}\\.?){2}(\\s?\\d{2})|(\\d\\/?\\s?\\d{3}|\\d{2}\\/?\\s?\\d{2})(\\.?\\s?\\d{2}){2})$"))) {
            message += "Please add a valid email address   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getAddress() == null) {
            message += "Please add an address   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getAddress().getStreetName() == null || createCustomerDTO.getAddress().getStreetName().isBlank()) {
            message += "Please add a street name   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getAddress().getNumber() == null || createCustomerDTO.getAddress().getNumber().isBlank()) {
            message += "Please add a number   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getAddress().getPostalCode() == null || createCustomerDTO.getAddress().getPostalCode().isBlank()) {
            message += "Please add a postal code   ";
            controlFactor = true;
        }

        if (createCustomerDTO.getAddress().getCity() == null || createCustomerDTO.getAddress().getCity().isBlank()) {
            message += "Please add a city";
            controlFactor = true;
        }

        if (controlFactor) {
            throw new ValidateCustomerInput(message);
        }

    }


    /*private static void validateAuthorization(String authorization) {
        if (authorization == null) {
            throw new AuthorizationNotFilled("The authorization is not filled in");
        }
    }*/
}
