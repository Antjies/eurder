package com.switchfully.eurder.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    @Test
    public void testConstructorAndGetters() {
        String streetName = "Main Street";
        String number = "123";
        String postalCode = "1000";
        String city = "Brussels";

        Address address = new Address(streetName, number, postalCode, city);

        assertEquals(streetName, address.getStreetName());
        assertEquals(number, address.getNumber());
        assertEquals(postalCode, address.getPostalCode());
        assertEquals(city, address.getCity());
    }
}
