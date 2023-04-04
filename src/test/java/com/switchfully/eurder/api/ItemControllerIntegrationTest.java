package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.models.Currency;
import com.switchfully.eurder.domain.models.Item;
import com.switchfully.eurder.domain.models.Price;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.domain.repositories.UserCredentialsRepository;
import com.switchfully.eurder.service.dtos.CreateItemDTO;
import com.switchfully.eurder.service.dtos.ItemDTO;
import com.switchfully.eurder.service.dtos.PriceDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Test
    void whenAddingAnItem_theItemRepoIsNoLongerEmpty() {
        Assertions.assertThat(itemRepository).isNotNull();
        Assertions.assertThat(userCredentialsRepository).isNotNull();

        CreateItemDTO newItem = new CreateItemDTO()
                .setName("test apples")
                .setDescription("testing apples")
                .setAmountInStock(10)
                .setPrice(new PriceDTO(0.4, Currency.Euro));


        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newItem)
                //.header(new Header("Authorization", "Basic username:password"))
                .auth().preemptive().basic("admin", "pwd")
                .log().all()
                .when()
                .port(port)
                .post("/items") // http://localhost:8080/
                // THEN
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value()); // status 201
                //.extract()
                //.as(Item.class); // Get a Item from the system
        // -> extracten kan enkel als je methode niet void is!

        Assertions.assertThat(itemRepository.getAllItems()).hasSize(1);


    }
}
