package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Admin;
import com.switchfully.eurder.domain.models.UserCredentials;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.exception.exceptions.AuthorizationNotFilled;
import com.switchfully.eurder.service.dtos.*;
import com.switchfully.eurder.service.mappers.UserCredentialsMapper;
import com.switchfully.eurder.service.mappers.UserMapper;
import com.switchfully.eurder.service.validation.AdminValidationAtCreationService;
import com.switchfully.eurder.service.validation.CustomerValidationAtCreationService;
import com.switchfully.eurder.service.wrappers.AdminWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CustomerValidationAtCreationService customerValidationAtCreationService;
    private final AdminValidationAtCreationService adminValidationAtCreationService;
    private final UserCredentialsMapper userCredentialsMapper;
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, CustomerValidationAtCreationService customerValidationAtCreationService, AdminValidationAtCreationService adminValidationAtCreationService, UserCredentialsMapper userCredentialsMapper, UserCredentialsRepository userCredentialsRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.customerValidationAtCreationService = customerValidationAtCreationService;
        this.adminValidationAtCreationService = adminValidationAtCreationService;
        this.userCredentialsMapper = userCredentialsMapper;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    public void registerNewCustomer(CreateCustomerDTO createCustomerDTO) {
        customerValidationAtCreationService.validateCustomer(createCustomerDTO); // validation to create new customer
        userRepository.addCustomer(userMapper.toDomain(createCustomerDTO));
    }

    public CustomerDTO getCustomerById(String id) {
        return userMapper.toCustomerDTO(userRepository.getCustomerById(id));
    }

    public Collection<CustomerDTO> getAllCustomers() {
        return userMapper.customerToCollectionDTO(userRepository.getAllCustomers());
    }

    public Collection<AdminDTO> getAllAdmins() {
        return userMapper.adminToCollectionDTO(userRepository.getAllAdmins());
    }

    public void createAdminWithRequestWrapper(AdminWrapper adminWrapper) {
        validateAdminWrapper(adminWrapper);
        Admin admin = userMapper.toAdminDomain(adminWrapper.getUser());
        UserCredentials adminCredentials = userCredentialsMapper.toDomain(adminWrapper.getUserCredentials());
        userRepository.addAdmin(admin);
        userCredentialsRepository.addCredentials(adminCredentials, admin);
    }

    private void validateAdminWrapper(AdminWrapper adminWrapper){
        if(adminWrapper.getUserCredentials() == null || adminWrapper.getUser() == null){
            throw new IllegalArgumentException("admin data and userCredentials data should be filled.");
        }
        validateUserCredentialsDTO(adminWrapper.getUserCredentials());
        validateLastName(adminWrapper.getUser().getLastName());
        validateMail(adminWrapper.getUser().getEmailAddress());
    }

    private void validateUserCredentialsDTO(UserCredentialsDTO userCredentialsDTO){
        if(userCredentialsDTO.getUsername() == null || userCredentialsDTO.getPassword() == null){
            throw new IllegalArgumentException(" should be filled.");
        }
    }

    // adding a validation to check if the admin already exists

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new RuntimeException();
        }
    }

    private void validateMail(String email) {
        if (email == null || email.isBlank() || !(email.matches("^(.+)@(\\S+)$"))) {
            throw new RuntimeException();
        }
    }

    private static void validateAuthorization(String authorization) {
        if (authorization == null) {
            throw new AuthorizationNotFilled("The authorization is not filled in");
        }
    }



}
