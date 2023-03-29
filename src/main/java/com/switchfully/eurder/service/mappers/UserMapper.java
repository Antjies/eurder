package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.Admin;
import com.switchfully.eurder.domain.models.Customer;
import com.switchfully.eurder.service.dtos.AdminDTO;
import com.switchfully.eurder.service.dtos.CreateAdminDTO;
import com.switchfully.eurder.service.dtos.CreateCustomerDTO;
import com.switchfully.eurder.service.dtos.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private AddressMapper addressMapper;

    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Customer toDomain(CreateCustomerDTO createCustomerDTO) {
        return new Customer(createCustomerDTO.getFirstName(), createCustomerDTO.getLastName(), createCustomerDTO.getEmailAddress(), addressMapper.toDomain(createCustomerDTO.getAddress()), createCustomerDTO.getPhoneNumber());
    }

    public CreateCustomerDTO toCreateCustomerDTO(Customer customer) {
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

    public Collection<CustomerDTO> customerToCollectionDTO(Collection<Customer> allCustomers) {
        return allCustomers.stream()
                .map(f -> toCustomerDTO(f))
                .collect(Collectors.toList());
    }

    public Admin toAdminDomain(CreateAdminDTO createAdminDTO) {
        return new Admin(createAdminDTO.getFirstName(), createAdminDTO.getLastName(), createAdminDTO.getEmailAddress());
    }

    public AdminDTO toAdminDTO(Admin admin){
        return new AdminDTO()
                .setId(admin.getId())
                .setFirstName(admin.getFirstName())
                .setLastName(admin.getLastName())
                .setEmailAddress(admin.getEmailAddress());

    }

    public AdminDTO toCreateAdminDTO(Admin admin){
        return new AdminDTO()
                .setFirstName(admin.getFirstName())
                .setLastName(admin.getLastName())
                .setEmailAddress(admin.getEmailAddress());
    }

    public Collection<AdminDTO> adminToCollectionDTO(Collection<Admin> admins) {
        return admins.stream()
                .map(f -> toAdminDTO(f))
                .collect(Collectors.toList());
    }
}
