package com.switchfully.eurder.exception.exceptions;

public class CustomerEmailAddressAlreadyExists extends RuntimeException {
    public CustomerEmailAddressAlreadyExists(String message) {
        super(message);
    }
}
