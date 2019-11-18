package com.blueground.assignment.dto;

import com.blueground.assignment.entity.ReviewEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserResponseDto {
    String username;
    Set<ReviewEntity> reviews = new HashSet<>();
    String phoneNumber;
    String name;
    String surName;
    String email;

    public UserResponseDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserResponseDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public UserResponseDto setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserResponseDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponseDto setName(String firstName) {
        this.name = firstName;
        return this;
    }

    public String getLastName() {
        return surName;
    }

    public UserResponseDto setSurName(String lastName) {
        this.surName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
