package com.restfulproject.dhrubo.payload;

public class ApiResponsePatientInsert {

    private String status;

    public ApiResponsePatientInsert(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
