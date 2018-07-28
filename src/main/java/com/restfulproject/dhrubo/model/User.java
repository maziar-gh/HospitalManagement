package com.restfulproject.dhrubo.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank
    @Size(max = 40)
    private String first_name;


    @NotBlank
    @Size(max = 40)
    private String last_name;


    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;


    @NotBlank
    @Size(max = 40)
    private String mobile;

    @NotBlank
    @Size(max = 40)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User(){
        id=0;
    }

    public User(String first_name, String last_name, String email, String mobile, String password) {
        this.id = id;

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
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


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}