package com.dheredia.unitesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiThereController {

    @GetMapping("/hi-there")
    public String HiTheredController (){
        return "Hi there";
    }
}
