package com.restfulproject.dhrubo.model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity

@Table(name = "users", uniqueConstraints = {


        @UniqueConstraint(columnNames = {

                "username"

        })

})

public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @NotBlank

    @Size(max = 40)

    private String first_name;



    @NotBlank

    @Size(max = 15)

    private String last_name;



    @NotBlank

    @Size(max = 40)

    @Email

    @NaturalId
    private String username;



    @NotBlank
    @Size(max = 12)
    private String mobile;



    @NotBlank

    @Size(max = 100)

    private String password;






    public User() {



    }



    public User(String first_name, String last_name, String username, String mobile,String password) {

        this.first_name = first_name;

        this.last_name = last_name;

        this.username = username;

        this.mobile = mobile;

        this.password = password;

    }




    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    public String getFirst_name() {

        return first_name;

    }



    public void setFirst_name(String first_name) {

        this.first_name = first_name;

    }



    public String getLast_name() {

        return last_name;

    }



    public void setLast_name(String last_name) {

        this.last_name = last_name;

    }




    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
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
