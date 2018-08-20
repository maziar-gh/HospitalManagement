package com.restfulproject.dhrubo.payload;

public class ApiResponseDoctorInsert {
    private String status;

    public ApiResponseDoctorInsert(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
