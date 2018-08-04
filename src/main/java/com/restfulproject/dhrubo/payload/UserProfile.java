package com.restfulproject.dhrubo.payload;




public class UserProfile {


    private String first_name;


    private String last_name;



    private String email;

    private String mobile;



    private String status;






    public UserProfile() {



    }



    public UserProfile(String first_name, String last_name, String email, String mobile,String status) {

        this.first_name = first_name;

        this.last_name = last_name;

        this.email = email;

        this.mobile = mobile;

        this.status = status;

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

    @Override
    public String toString() {
        return "UserProfile{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {

        return status;

    }



    public void setStatus(String status) {

        this.status = status;

    }

}
