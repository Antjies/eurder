package com.switchfully.eurder.service.validation;

import com.switchfully.eurder.domain.models.Address;
import com.switchfully.eurder.exception.exceptions.CustomerFirstNameIsEmpty;
import com.switchfully.eurder.service.dtos.AddressDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;


public class CustomerValidationAtCreationService {

    public static void validateCustomer(CreateCustomerDTO createCustomerDTO){
        CustomerValidationAtCreationService.validateFirstName(createCustomerDTO.getFirstName());
        CustomerValidationAtCreationService.validateLastName(createCustomerDTO.getFirstName());
        CustomerValidationAtCreationService.validateEmailAddress(createCustomerDTO.getEmailAddress());
        CustomerValidationAtCreationService.validateAddress(createCustomerDTO.getAddress());
        CustomerValidationAtCreationService.validatePhoneNumber(createCustomerDTO.getPhoneNumber());
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new CustomerFirstNameIsEmpty("Please add a first name to register");
        }
    }

    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new RuntimeException();
        }
    }

    private static void validateEmailAddress(String email) {
        if (email == null || email.isBlank() || !(email.matches("^(.+)@(\\S+)$"))) {
            throw new RuntimeException();
        }
    }

    private static void validateAddress(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new RuntimeException();
        }
        if (addressDTO.getStreetName() == null || addressDTO.getStreetName().isBlank()) {
            throw new RuntimeException();
        }
        if (addressDTO.getNumber() == null || addressDTO.getNumber().isBlank()) {
            throw new RuntimeException();
        }
        if (addressDTO.getPostalCode() == null || addressDTO.getPostalCode().isBlank()) {
            throw new RuntimeException();
        }
        if (addressDTO.getCity() == null || addressDTO.getCity().isBlank()) {
            throw new RuntimeException();
        }
    }

    private static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank() || !(phoneNumber.matches("^(((\\+|00)32[ ]?(?:\\(0\\)[ ]?)?)|0){1}(4(60|[789]\\d)\\/?(\\s?\\d{2}\\.?){2}(\\s?\\d{2})|(\\d\\/?\\s?\\d{3}|\\d{2}\\/?\\s?\\d{2})(\\.?\\s?\\d{2}){2})$"))) {
            throw new RuntimeException();
        }
    }

    /*private static void validateAuthorization(String authorization) {
        if (authorization == null) {
            throw new AuthorizationNotFilled("The authorization is not filled in");
        }
    }*/
}
