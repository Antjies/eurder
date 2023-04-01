package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.models.*;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository = new UserCredentialsRepository();
    private UserRepository userRepository = new UserRepository(userCredentialsRepository);

    /*@Test
    public void whenT() {
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
        Item toCheckCustomer = RestAssured
                .given()
                .contentType(ContentType.JSON)
                //.header(new Header("Authorization", "Basic username:password"))
                .auth().preemptive().basic("admin", "pwd")
                .log().all()
                .when()
                .port(8080)
                .get("/user/" + newCustomer.getId()) // http://localhost:8080/
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.OK.value()) // status 200
                .extract()
                .as(Item.class); // Get a Item from the system

        Assertions.assertThat(newCustomer).isEqualTo(toCheckCustomer);
    }*/
}
