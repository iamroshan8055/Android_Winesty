package com.example.roshantirthyash_groupproj;

public class Users {

    private Integer user_profile_image;
    private String user_username;
    private String user_email;
    private String user_password;

    public Users(String user_username, String user_email, String user_password) {
    }

//    public Integer getUser_profile_image() {
//        return user_profile_image;
//    }
//    public void setUser_profile_image(Integer profile_image) { this.user_profile_image = profile_image; }

    public String getUser_username() {
        return user_username;
    }
    public void setUser_username(String u_Username) {
        this.user_username = u_Username;
    }

    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String u_Email) {
        this.user_email = u_Email;
    }

    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String u_Password) {
        this.user_password = u_Password;
    }

}
