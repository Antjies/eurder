package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.models.Currency;
import com.switchfully.eurder.domain.models.Item;
import com.switchfully.eurder.domain.models.Price;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import com.switchfully.eurder.service.dtos.CreateItemDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // resets info each method
public class ItemControllerIntegrationTest {

    @Autowired
    private ItemRepository itemRepository = new ItemRepository();


}
