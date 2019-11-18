package com.blueground.assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "users")
public class UserEntity {
    @Id
    @Column(name = "USERNAME", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 256)
    private String password;
    @Basic
    @Column(name = "NAME", length = 45)
    private String name;
    @Basic
    @Column(name = "SURNAME", length = 45)
    private String surname;
    @Basic
    @Column(name = "EMAIL", length = 45)
    private String email;
    @Basic
    @Column(name = "PHONE_NUMBER", length = 45)
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewEntityPK.userEntity", cascade=CascadeType.ALL)
    private Set<ReviewEntity> reviews = new HashSet<>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> userReviews) {
        this.reviews = userReviews;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
