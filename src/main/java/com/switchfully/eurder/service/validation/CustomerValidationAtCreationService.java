package com.switchfully.eurder.service.validation;

import com.switchfully.eurder.domain.models.Address;
import com.switchfully.eurder.exception.exceptions.CustomerFirstNameIsEmpty;
import com.switchfully.eurder.service.dtos.AddressDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import org.springframework.stereotype.Component;


@Component
public class CustomerValidationAtCreationService {

    public void validateCustomer(CreateCustomerDTO createCustomerDTO){
        validateCustomerDTO(createCustomerDTO);
        validateAddressDTO(createCustomerDTO.getAddress());
        // ADD validation USER EMAIL already exists!
    }

    private void validateCustomerDTO(CreateCustomerDTO createCustomerDTO){
        if (createCustomerDTO.getFirstName() == null || createCustomerDTO.getFirstName().isBlank()) {
            throw new CustomerFirstNameIsEmpty("Please add a first name to register");
        }

        if (createCustomerDTO.getLastName() == null || createCustomerDTO.getLastName().isBlank()) {
            throw new RuntimeException();
        }

        if (createCustomerDTO.getEmailAddress() == null || createCustomerDTO.getEmailAddress().isBlank() || !(createCustomerDTO.getEmailAddress().matches("^(.+)@(\\S+)$"))) {
            throw new RuntimeException();
        }
        if (createCustomerDTO.getPhoneNumber() == null || createCustomerDTO.getPhoneNumber().isBlank() || !(createCustomerDTO.getPhoneNumber().matches("^(((\\+|00)32[ ]?(?:\\(0\\)[ ]?)?)|0){1}(4(60|[789]\\d)\\/?(\\s?\\d{2}\\.?){2}(\\s?\\d{2})|(\\d\\/?\\s?\\d{3}|\\d{2}\\/?\\s?\\d{2})(\\.?\\s?\\d{2}){2})$"))) {
            throw new RuntimeException();
        }

    }

    private static void validateAddressDTO(AddressDTO addressDTO) {
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

    /*private static void validateAuthorization(String authorization) {
        if (authorization == null) {
            throw new AuthorizationNotFilled("The authorization is not filled in");
        }
    }*/
}
