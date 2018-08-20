package com.restfulproject.dhrubo.payload;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class InsertPatientRequest {

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String mobile;


    @NotBlank
    @Size(max = 12)
    private String age;

    @NotBlank
    @Size(max = 10)
    private String gender;

    @NotBlank
    @Size(max = 50)
    private String occupation;

    @NotBlank
    @Size(max = 100)
    private String symptom_summary;


    public InsertPatientRequest() {


    }


    public InsertPatientRequest(String name, String mobile, String age, String gender, String occupation, String symptom_summary) {
        this.name = name;
        this.mobile = mobile;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.symptom_summary = symptom_summary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSymptom_summary() {
        return symptom_summary;
    }

    public void setSymptom_summary(String symptom_summary) {
        this.symptom_summary = symptom_summary;
    }
}
