package com.example.dev.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreateRequest {
    @Size(min = 6, message = "Username must be at least 6 character")
    private String username;

    @Size(min = 8, message = "Password must be at least 8 character")
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}