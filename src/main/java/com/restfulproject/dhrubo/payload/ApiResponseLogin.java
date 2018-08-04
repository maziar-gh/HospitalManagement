package com.restfulproject.dhrubo.payload;

public class ApiResponseLogin {
    private String first_name;
    private String email;
    private String status;

    public ApiResponseLogin(String first_name, String email, String status) {

        this.first_name = first_name;
        this.email = email;
        this.status = status;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
