package com.EntitiesAPP;

import org.springframework.stereotype.Component;

@Component
public class mainuser {
    Long userId;
    String firstName;
    String userName;
    String email;

    public mainuser() {

    }


    public mainuser(Long userId, String firstName, String userName, String email, String userPassword) {
        this.userId = userId;
        this.firstName = firstName;
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    String userPassword;
}