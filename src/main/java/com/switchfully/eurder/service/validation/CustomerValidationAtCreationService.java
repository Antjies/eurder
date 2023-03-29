package com.switchfully.eurder.service.validation;

import com.switchfully.eurder.exception.exceptions.ValidateCustomerInput;
import com.switchfully.eurder.exception.exceptionsnotused.CustomerEmailAddressDoesntMatchRequirement;
import com.switchfully.eurder.exception.exceptionsnotused.CustomerFirstNameIsEmpty;
import com.switchfully.eurder.exception.exceptionsnotused.CustomerLastNameIsEmpty;
import com.switchfully.eurder.exception.exceptionsnotused.CustomerPhoneNumberDoesntMatchRequirement;
import com.switchfully.eurder.service.dtos.AddressDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import org.springframework.stereotype.Component;


@Component
public class CustomerValidationAtCreationService {

    public void validateCustomer(CreateCustomerDTO createCustomerDTO){
        validateCustomerDTO(createCustomerDTO);
        // ADD validation USER EMAIL already exists!
    }

    private void validateCustomerDTO(CreateCustomerDTO createCustomerDTO){
        boolean controlFactor = false;
        String message = "";

        if (createCustomerDTO.getFirstName() == null || createCustomerDTO.getFirstName().isBlank()) {
            message += "Please add a first name to register   ";
            controlFactor = true;
            //throw new CustomerFirstNameIsEmpty("Please add a first name to register");
        }

        if (createCustomerDTO.getLastName() == null || createCustomerDTO.getLastName().isBlank()) {
            message += "Please add a last name to register   ";
            controlFactor = true;
            //throw new CustomerLastNameIsEmpty("Please add a last name to register");
        }

        if (createCustomerDTO.getEmailAddress() == null || createCustomerDTO.getEmailAddress().isBlank() || !(createCustomerDTO.getEmailAddress().matches("^(.+)@(\\S+)$"))) {
            message += "Please add a valid email address   ";
            controlFactor = true;
            //throw new CustomerEmailAddressDoesntMatchRequirement("Please add a valid email address");
        }

        if (createCustomerDTO.getPhoneNumber() == null || createCustomerDTO.getPhoneNumber().isBlank() || !(createCustomerDTO.getPhoneNumber().matches("^(((\\+|00)32[ ]?(?:\\(0\\)[ ]?)?)|0){1}(4(60|[789]\\d)\\/?(\\s?\\d{2}\\.?){2}(\\s?\\d{2})|(\\d\\/?\\s?\\d{3}|\\d{2}\\/?\\s?\\d{2})(\\.?\\s?\\d{2}){2})$"))) {
            message += "Please add a valid email address   ";
            controlFactor = true;
            //throw new CustomerPhoneNumberDoesntMatchRequirement("Please add a valid phonenumber");
        }

        if (createCustomerDTO.getAddress() == null) {
            message += "Please add an address   ";
            controlFactor = true;
            //throw new RuntimeException();
        }

        if (createCustomerDTO.getAddress().getStreetName() == null || createCustomerDTO.getAddress().getStreetName().isBlank()) {
            message += "Please add a street name   ";
            controlFactor = true;
            //throw new RuntimeException();
        }

        if (createCustomerDTO.getAddress().getNumber() == null || createCustomerDTO.getAddress().getNumber().isBlank()) {
            message += "Please add a number   ";
            controlFactor = true;
            //throw new RuntimeException();
        }

        if (createCustomerDTO.getAddress().getPostalCode() == null || createCustomerDTO.getAddress().getPostalCode().isBlank()) {
            message += "Please add a postal code   ";
            controlFactor = true;
            //throw new RuntimeException();
        }

        if (createCustomerDTO.getAddress().getCity() == null || createCustomerDTO.getAddress().getCity().isBlank()) {
            message += "Please add a city";
            controlFactor = true;
            //throw new RuntimeException();
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
