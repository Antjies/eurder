package com.switchfully.eurder.exception;

import com.switchfully.eurder.exception.exceptions.*;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(CustomerNotFoundException.class)
    protected void CustomerNotFoundException(CustomerNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(CustomerEmailAddressAlreadyExists.class)
    protected void CustomerEmailAddressAlreadyExists(CustomerEmailAddressAlreadyExists ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ValidateCustomerInput.class)
    protected void ValidateCustomerInput(ValidateCustomerInput ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ValidateAdminInput.class)
    protected void ValidateAdminInput(ValidateAdminInput ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    protected void unauthorizedAccessException(UnauthorizedAccessException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }

    /*@ExceptionHandler(AuthorizationNotFilled.class)
    protected void authorizationNotFilled(AuthorizationNotFilled ex, HttpServletResponse response) throws IOException {
        logger.error(ex.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }*/




}
