package com.dheredia.unitesting.controller;

import com.dheredia.unitesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/item")
    public Item ItemController (){
        return new Item(1,"Ball", 10, 100);
    }
}
