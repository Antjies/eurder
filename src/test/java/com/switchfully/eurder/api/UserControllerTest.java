package com.switchfully.eurder.api;

import com.switchfully.eurder.exception.exceptions.CustomerNotFoundException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // resets info each method
public class UserControllerTest {

    @Test
    void testExceptionBeingThrownWhen_CustomById_ButIdIsWrong() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                //.header(new Header("Authorization", "Basic username:password"))
                .auth().preemptive().basic("admin", "pwd")
                .log().all()
                .when()
                .port(8080)
                .get("/users/customers/1") // http://localhost:8080/users/customers/1
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(404); // status 404
    }



}
