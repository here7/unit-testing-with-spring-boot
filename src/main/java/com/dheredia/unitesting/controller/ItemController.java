package com.dheredia.unitesting.controller;

import com.dheredia.unitesting.ItemBusinessService;
import com.dheredia.unitesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/item")
    public Item ItemController (){
        return new Item(1,"Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item ItemFromBusinessServiceController (){
        return businessService.retreiveHardcodedItem();
    }
}
