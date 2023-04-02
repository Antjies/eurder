package com.switchfully.eurder.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchfully.eurder.domain.models.Currency;
import com.switchfully.eurder.domain.models.Item;
import com.switchfully.eurder.domain.models.Price;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.domain.repositories.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // resets info each method
public class ItemControllerTest {

    @Autowired //each need connotation
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired  //each need connotation
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    /*@Test
    public void whenACustomerIsAddedViaController_CheckIfItemIsCreated() throws JsonProcessingException {

        Item newItem = new Item("test", "a test", new Price(10, Currency.Euro), 5);

        // Zet info om naar json -> voor body
        ObjectMapper objectMapper = new ObjectMapper();
        String itemJson = objectMapper.writeValueAsString(newItem);

        // WHEN
        Item toCheckItem = RestAssured
                .given()
                .contentType(ContentType.JSON)
                //.header(new Header("Authorization", "Basic username:password"))
                //.auth().preemptive().basic("admin", "pwd")
                //.log().all()
                .body(itemJson)
                .when()
                .port(8080)
                .post("/items/") // http://localhost:8080/items/
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value()) // status 201
                .extract()
                .as(Item.class); // Get a Customer from the system

        Assertions.assertThat(newItem).isEqualTo(toCheckItem);
    }*/









}
