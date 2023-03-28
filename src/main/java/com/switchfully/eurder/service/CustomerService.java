package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import com.switchfully.eurder.service.mappers.CustomerMapper;
import com.switchfully.eurder.service.validation.CustomerValidationAtCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerValidationAtCreationService customerValidationAtCreationService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, CustomerValidationAtCreationService customerValidationAtCreationService) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.customerValidationAtCreationService = customerValidationAtCreationService;
    }

    public CreateCustomerDTO registerNewCustomer(CreateCustomerDTO createCustomerDTO) {
        customerValidationAtCreationService.validateCustomer(createCustomerDTO);
        Customer newCustomer = customerMapper.toDomain(createCustomerDTO);
        return customerMapper.toDTO(customerRepository.addCustomer(newCustomer));
    }

    public CustomerDTO getCustomerById(String id) {
        return customerMapper.toCustomerDTO(customerRepository.getCustomerById(id));
    }

    public Collection<CustomerDTO> getAllCustomers() {
        return customerMapper.toCollectionDTO(customerRepository.getAllCustomers());
    }


}
