package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.domain.repositories.UserRepository;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import com.switchfully.eurder.service.mappers.UserMapper;
import com.switchfully.eurder.service.validation.CustomerValidationAtCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CustomerValidationAtCreationService customerValidationAtCreationService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, CustomerValidationAtCreationService customerValidationAtCreationService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.customerValidationAtCreationService = customerValidationAtCreationService;
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


}
