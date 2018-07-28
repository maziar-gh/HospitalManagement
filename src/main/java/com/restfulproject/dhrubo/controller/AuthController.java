package com.restfulproject.dhrubo.controller;


import com.restfulproject.dhrubo.exceptions.AppException;
import com.restfulproject.dhrubo.model.Role;
import com.restfulproject.dhrubo.model.RoleName;
import com.restfulproject.dhrubo.model.User;
import com.restfulproject.dhrubo.payload.ApiResponse;
import com.restfulproject.dhrubo.payload.JwtAuthenticationResponse;
import com.restfulproject.dhrubo.payload.LoginRequest;
import com.restfulproject.dhrubo.payload.SignUpRequest;
import com.restfulproject.dhrubo.repository.RoleRepository;
import com.restfulproject.dhrubo.repository.UserRepository;
import com.restfulproject.dhrubo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

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

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getFirst_name(), signUpRequest.getLast_name(),
                signUpRequest.getEmail(), signUpRequest.getMobile(),signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByEmail(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{useremail}")
                .buildAndExpand(result.getEmail()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}