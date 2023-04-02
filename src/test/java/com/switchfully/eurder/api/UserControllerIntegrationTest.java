package com.switchfully.eurder.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchfully.eurder.domain.models.*;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // resets info each method
//@RunWith(SpringRunner.class) // makes the autowired possible!!
public class UserControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired //each need connotation
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired  //each need connotation
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    //Deze zou moeten werken als Autowired zou werken! Ik krijg nullexception.
    /*@Test
    public void whenACustomerIsAddedInTheRepositoryItself_WhenCheckedViaController_CheckIfYouFindTheCustomer() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phoneNumber = "0478739282";
        String streetName = "Main Street";
        String number = "123";
        String postalCode = "1000";
        String city = "Brussels";
        Address address = new Address(streetName, number, postalCode, city);
        Customer newCustomer = new Customer(firstName, lastName, email, address, phoneNumber);
        userRepository.addCustomer(newCustomer);

        // WHEN
        Customer toCheckCustomer = RestAssured
                .given()
                .contentType(ContentType.JSON)
                //.header(new Header("Authorization", "Basic username:password"))
                .auth().preemptive().basic("admin", "pwd")
                .log().all()
                .when()
                .port(8080)
                .get("/users/customers/" + newCustomer.getId()) // http://localhost:8080/users/customers/{id}
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.OK.value()) // status 200
                .extract()
                .as(Customer.class); // Get a Customer from the system

        Assertions.assertThat(newCustomer).isEqualTo(toCheckCustomer);
    }*/

    // Zou ook moeten werken in theorie
    /*@Test
    public void whenACustomerIsAddedViaController_CheckIfItemIsCreated() throws JsonProcessingException {
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phoneNumber = "0478739282";
        String streetName = "Main Street";
        String number = "123";
        String postalCode = "1000";
        String city = "Brussels";
        Address address = new Address(streetName, number, postalCode, city);
        Customer newCustomer = new Customer(firstName, lastName, email, address, phoneNumber);

        // Zet info om naar json -> voor body
        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = objectMapper.writeValueAsString(newCustomer);

        // WHEN
        Customer toCheckCustomer = RestAssured
                .given()
                .contentType(ContentType.JSON)
                //.header(new Header("Authorization", "Basic username:password"))
                //.auth().preemptive().basic("admin", "pwd")
                //.log().all()
                .body(customerJson)
                .when()
                .port(8080)
                .post("/users/customers/") // http://localhost:8080/users/customers/
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value()) // status 201
                .extract()
                .as(Customer.class); // Get a Customer from the system

        Assertions.assertThat(newCustomer).isEqualTo(toCheckCustomer);
    }*/


    // werkt niet op basis van de repository omdat @Autowired niet werkt!
    @Test
    @DisplayName("Create a Customer")
    void create() {
        userCredentialsRepository = new UserCredentialsRepository();
        userRepository = new UserRepository(userCredentialsRepository);

        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phoneNumber = "0478739282";
        String streetName = "Main Street";
        String number = "123";
        String postalCode = "1000";
        String city = "Brussels";
        Address address = new Address(streetName, number, postalCode, city);
        Customer newCustomer = new Customer(firstName, lastName, email, address, phoneNumber);

        userRepository.addCustomer(newCustomer);

        assertThat(userRepository.getAllCustomers()).contains(newCustomer);
    }

    /*@Test
    public void whenACustomerIsAddedViaController_CheckIfItemIsCreated() throws JsonProcessingException {
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phoneNumber = "0478739282";
        String streetName = "Main Street";
        String number = "123";
        String postalCode = "1000";
        String city = "";
        Address address = new Address(streetName, number, postalCode, city);
        Customer newCustomer = new Customer(firstName, lastName, email, address, phoneNumber);

        // Zet info om naar json -> voor body
        ObjectMapper objectMapper = new ObjectMapper();
        String customerJson = objectMapper.writeValueAsString(newCustomer);

        // WHEN
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                //.header(new Header("Authorization", "Basic username:password"))
                //.auth().preemptive().basic("admin", "pwd")
                //.log().all()
                .body(customerJson)
                .when()
                .port(8080)
                .post("/users/customers/") // http://localhost:8080/users/customers/
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value()); // status 200

    }*/






}
