package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Admin;
import com.switchfully.eurder.domain.models.UserCredentials;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.service.dtos.AdminDTO;
import com.switchfully.eurder.service.dtos.CreateAdminDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
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

    public void registerNewAdmin(CreateAdminDTO createAdminDTO) {
        adminValidationAtCreationService.validateAdmin(createAdminDTO); // validation to create new admin
        userRepository.addAdmin(userMapper.toAdminDomain(createAdminDTO));
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
}
