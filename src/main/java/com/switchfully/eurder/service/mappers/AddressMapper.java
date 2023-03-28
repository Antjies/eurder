package com.switchfully.eurder.service.mappers;

import com.switchfully.eurder.domain.models.Address;
import com.switchfully.eurder.service.dtos.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toDomain(AddressDTO addressDTO) {
        return new Address(addressDTO.getStreetName(), addressDTO.getNumber(), addressDTO.getPostalCode(), addressDTO.getCity());
    }

    public AddressDTO toDTO (Address address) {
        return new AddressDTO()
                .setStreetName(address.getStreetName())
                .setNumber(address.getNumber())
                .setPostalCode(address.getPostalCode())
                .setCity(address.getCity());
    }
}
