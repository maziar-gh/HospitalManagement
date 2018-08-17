package com.restfulproject.dhrubo.controller;

import com.restfulproject.dhrubo.model.User;
import com.restfulproject.dhrubo.payload.ApiResponseLogin;
import com.restfulproject.dhrubo.payload.ApiResponseSignup;
import com.restfulproject.dhrubo.payload.LoginRequest;
import com.restfulproject.dhrubo.payload.SignupRequest;
import com.restfulproject.dhrubo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserRepository repository;

//    @GetMapping
//    public Iterable<User> findAll() {
//        return repository.findAll();
//    }

    @GetMapping(path = "/{username}")
    public User find(@PathVariable("username") String username) {
        return repository.findOne(username );
    }

    @PostMapping(value = "/signup",consumes = "application/json")
    public ApiResponseSignup create(@RequestBody User user) {
        User result = repository.save(user);
        return new ApiResponseSignup(result.getFirst_name(), result.getLast_name(), result.getEmail(), result.getMobile(), "user created");
    }

    @PostMapping(value = "/login",consumes = "application/json")
    public ApiResponseLogin login(@RequestBody LoginRequest loginRequest){
        User result = repository.findByEmail(loginRequest.getEmail());

        if(result!=null)
            return new ApiResponseLogin(result.getFirst_name(),result.getEmail(),"user Login Success");

        return new ApiResponseLogin("","","user login unsuccessful");
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        repository.delete(username);
    }

}