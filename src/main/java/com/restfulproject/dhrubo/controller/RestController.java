package com.restfulproject.dhrubo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping("/register")
    public String register(){
        return "Registration Successful";
    }


    @RequestMapping("/login")
    public String login(){
        return "Login Successful";
    }




    @RequestMapping("/api/insert/patient/new")
    public String addNewPatient(){
        return "new patient added";
    }

}
