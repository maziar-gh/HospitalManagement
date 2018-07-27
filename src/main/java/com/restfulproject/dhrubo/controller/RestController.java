package com.restfulproject.dhrubo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }



}
