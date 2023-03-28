package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private AddressMapper addressMapper;

    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Customer toDomain(CreateCustomerDTO createCustomerDTO) {
        return new Customer(createCustomerDTO.getFirstName(), createCustomerDTO.getLastName(), createCustomerDTO.getEmailAddress(), addressMapper.toDomain(createCustomerDTO.getAddress()), createCustomerDTO.getPhoneNumber());
    }

    public CreateCustomerDTO toDTO(Customer customer) {
        return new CreateCustomerDTO()
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setAddress(addressMapper.toDTO(customer.getAddress()))
                .setEmailAddress(customer.getEmailAddress())
                .setPhoneNumber(customer.getPhoneNumber());
    }

    public CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setAddress(addressMapper.toDTO(customer.getAddress()))
                .setEmailAddress(customer.getEmailAddress())
                .setPhoneNumber(customer.getPhoneNumber());
    }

    public Collection<CustomerDTO> toCollectionDTO(Collection<Customer> allCustomers) {
        return allCustomers.stream()
                .map(f -> toCustomerDTO(f))
                .collect(Collectors.toList());
    }
}
