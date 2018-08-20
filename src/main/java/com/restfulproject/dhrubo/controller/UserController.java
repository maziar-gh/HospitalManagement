package com.restfulproject.dhrubo.controller;

import com.restfulproject.dhrubo.model.User;
import com.restfulproject.dhrubo.payload.*;
import com.restfulproject.dhrubo.repository.UserRepository;
import com.restfulproject.dhrubo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.tools.web.BadHttpRequest;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

//    @GetMapping
//    public Iterable<User> findAll() {
//        return repository.findAll();
//    }



    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(path = "/{username}")
    public User find(@PathVariable("username") String username) {
        return userRepository.findOne(username);
    }

    @PostMapping(value = "/signup",consumes = "application/json")
    public ApiResponseSignup create(@RequestBody SignupRequest user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User temp = new User(user.getFirs_name(),user.getLast_name(),user.getEmail(),user.getMobile(),user.getPassword());
        User result = userRepository.save(temp);
        return new ApiResponseSignup(result.getFirst_name(), result.getLast_name(), result.getUsername(), result.getMobile(), "user created");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        userRepository.delete(username);
    }

}