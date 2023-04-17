package com.pablox.citystatespart2.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {
    @NotEmpty(message="Your email is required")
    @Email(message="Please enter a valid email!")
    private String email;

    @NotEmpty(message="Your password is required")
    private String password;

    public LoginUser() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
