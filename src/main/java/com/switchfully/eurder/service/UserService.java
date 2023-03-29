package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.service.dtos.AdminDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import com.switchfully.eurder.service.mappers.UserMapper;
import com.switchfully.eurder.service.validation.AdminValidationAtCreationService;
import com.switchfully.eurder.service.validation.CustomerValidationAtCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CustomerValidationAtCreationService customerValidationAtCreationService;
    private final AdminValidationAtCreationService adminValidationAtCreationService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, CustomerValidationAtCreationService customerValidationAtCreationService, AdminValidationAtCreationService adminValidationAtCreationService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.customerValidationAtCreationService = customerValidationAtCreationService;
        this.adminValidationAtCreationService = adminValidationAtCreationService;
    }

    public void registerNewCustomer(CreateCustomerDTO createCustomerDTO) {
        customerValidationAtCreationService.validateCustomer(createCustomerDTO); // validation to create new customer -> need same for admin!
        Customer newCustomer = userMapper.toDomain(createCustomerDTO);
        userRepository.addCustomer(newCustomer);
        userMapper.toDTO(newCustomer);
    }

    public CustomerDTO getCustomerById(String id) {
        return userMapper.toCustomerDTO(userRepository.getCustomerById(id));
    }

    public Collection<CustomerDTO> getAllCustomers() {
        return userMapper.toCollectionDTO(userRepository.getAllCustomers());
    }


    public void registerNewAdmin(AdminDTO adminDTO) {
        adminValidationAtCreationService.validateAdmin(adminDTO); // validation to create new admin

    }
}
