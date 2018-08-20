package com.restfulproject.dhrubo.payload;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class SignupRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String firs_name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String last_name;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String mobile;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    public SignupRequest(){

    }

    public SignupRequest(String firs_name, String last_name, String email, String mobile, String password) {
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirst_name(String firs_name) {
        this.firs_name = firs_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
