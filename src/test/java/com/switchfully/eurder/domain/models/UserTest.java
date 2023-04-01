package com.switchfully.eurder.domain.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    Address address;

    @BeforeEach
    void preperation(){
        String streetName = "Main Street";
        String number = "123";
        String postalCode = "1000";
        String city = "Brussels";

        address = new Address(streetName, number, postalCode, city);

    }

    @Test
    void givenTwoUsersWithSameEmail_whenEquals_thenTrue() {
        // Given
        User user1 = new Customer("John", "Doe", "johndoe@example.com", address, "0478732982");
        User user2 = new Customer("Jane", "Doe", "johndoe@example.com", address, "0478732982");

        // When
        boolean result = user1.equals(user2);

        // Then
        assertTrue(result);
    }

    @Test
    void givenTwoUsersWithDifferentEmails_whenEquals_thenFalse() {
        // Given
        User user1 = new Customer("John", "Doe", "johndoe@example.com", address, "0478732982");
        User user2 = new Customer("Jane", "Doe", "janedoe@example.com", address, "0478732982");

        // When
        boolean result = user1.equals(user2);

        // Then
        assertFalse(result);
    }

    @Test
    void givenUser_whenCanHaveAccessToFeature_thenTrue() {
        // Given
        User user = new Customer("John", "Doe", "johndoe@example.com", address, "0478732982");

        // When
        boolean result = user.canHaveAccessTo(Feature.CAN_ORDER_ITEMS);

        // Then
        assertTrue(result);
    }

    @Test
    void givenUser_whenCannotHaveAccessToFeature_thenFalse() {
        // Given
        User user = new Customer("John", "Doe", "johndoe@example.com", address, "0478732982");

        // When
        boolean result = user.canHaveAccessTo(Feature.CAN_CREATE_ADMIN);

        // Then
        assertFalse(result);
    }

    @Test
    public void givenValidData_whenCreatingUser_thenNoExceptionIsThrown() {
        // given
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phoneNumber = "0478739282";

        // when
        Customer user = new Customer(firstName, lastName, email, address, phoneNumber);

        // then
        assertNotNull(user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmailAddress());
        assertEquals(phoneNumber, user.getPhoneNumber());
    }


}
