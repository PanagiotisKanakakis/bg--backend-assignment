package com.blueground.assignment.dto;

import com.blueground.assignment.entity.ReviewEntity;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {

    String username;
    List<ReviewEntity> reviews = new ArrayList<>();
    String phoneNumber;
    String name;
    String surName;
    String email;

    public UserResponseDTO() { }

    public String getUsername() {
        return username;
    }

    public UserResponseDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public UserResponseDTO setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserResponseDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponseDTO setName(String firstName) {
        this.name = firstName;
        return this;
    }

    public String getLastName() {
        return surName;
    }

    public UserResponseDTO setSurName(String lastName) {
        this.surName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
