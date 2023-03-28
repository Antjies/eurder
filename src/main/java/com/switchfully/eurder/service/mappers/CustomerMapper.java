package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import org.springframework.stereotype.Component;

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
}
