package com.switchfully.eurder.api;

import com.switchfully.eurder.domain.models.Feature;
import com.switchfully.eurder.service.ItemService;
import com.switchfully.eurder.service.SecurityService;
import com.switchfully.eurder.service.dtos.CreateItemDTO;
import com.switchfully.eurder.service.dtos.ItemDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "items")
public class ItemController {

    private final ItemService itemService;
    private final SecurityService securityService;
    private final Logger myLogger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    //Story 2: Creating a new Item -> Need to be Admin
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public void addNewItem(@RequestBody CreateItemDTO createItemDTO, @RequestHeader String authorization) {
        myLogger.info("Handler method AddNewItem is called");
        securityService.validateAuthorization(authorization, Feature.CAN_ADD_ITEMS);
        itemService.addNewItem(createItemDTO);
    }

    //Story 4: Update an Item -> Need to be Admin
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(security = @SecurityRequirement(name = "basicAuth")) // verwijzing nodig naar swaggerconfig
    public ItemDTO updateItemById(@PathVariable String id, @RequestBody ItemDTO itemDTO , @RequestHeader String authorization){
        myLogger.info("Handler method updateItemById is called");
        securityService.validateAuthorization(authorization, Feature.CAN_UPDATE_AN_ITEM);
        return itemService.updateItemById(id, itemDTO);
    }

    //View all Items -> You don't have to register to see our products!
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ItemDTO> getAllItems() {
        myLogger.info("Handler method getAllItems is called");
        return itemService.getAllItems();
    }






}
