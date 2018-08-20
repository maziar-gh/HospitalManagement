package com.restfulproject.dhrubo.payload;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class InsertDoctorRequest {

    @NotBlank

    @Size(max = 40)

    private String doctor_name;








    @NotBlank

    @Size(max = 40)

    private String department;


    @NotBlank
    @Size(max = 12)
    private String date;






    public InsertDoctorRequest() {



    }



    public InsertDoctorRequest(String doctor_name, String department, String date) {

        this.doctor_name = doctor_name;
        this.department = department;
        this.date = date;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
