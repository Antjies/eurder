package com.switchfully.eurder.exception.exceptions;

public class CustomerBoughtNothingException extends RuntimeException{
    public CustomerBoughtNothingException(String message) {
        super(message);
    }
}
