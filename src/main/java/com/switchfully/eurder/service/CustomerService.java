package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.domain.repositories.CustomerRepository;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import com.switchfully.eurder.service.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CreateCustomerDTO registerNewCustomer(CreateCustomerDTO createCustomerDTO) {
        Customer newCustomer = customerMapper.toDomain(createCustomerDTO);
        return customerMapper.toDTO(customerRepository.addCustomer(newCustomer));
    }

    public CustomerDTO getCustomerById(String id) {
        return customerMapper.toCustomerDTO(customerRepository.getCustomerById(id));
    }
}
