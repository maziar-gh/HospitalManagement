package com.restfulproject.dhrubo.payload;

import org.hibernate.validator.constraints.NotBlank;


public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }


}