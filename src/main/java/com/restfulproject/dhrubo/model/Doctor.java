package com.restfulproject.dhrubo.model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity

@Table(name = "doctors", uniqueConstraints = {


        @UniqueConstraint(columnNames = {

                "id"

        })

})
public class Doctor {



    @Id
    @NaturalId
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @NotBlank

    @Size(max = 40)

    private String doctor_name;








    @NotBlank

    @Size(max = 40)

    private String department;


    @NotBlank
    @Size(max = 12)
    private String date;






    public Doctor() {



    }



    public Doctor(String doctor_name, String department, String date) {

        this.doctor_name = doctor_name;
        this.department = department;
        this.date = date;
    }




    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

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
