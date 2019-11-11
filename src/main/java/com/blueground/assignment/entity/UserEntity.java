package com.blueground.assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Users")
public class UserEntity {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String salt;
    private List<ReviewEntity> reviews = new ArrayList<>();

    @Id
    @Column(name = "USERNAME", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SURNAME", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = false, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "SALT", nullable = false, length = 200)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(username, userEntity.username) &&
                Objects.equals(password, userEntity.password) &&
                Objects.equals(name, userEntity.name) &&
                Objects.equals(surname, userEntity.surname) &&
                Objects.equals(email, userEntity.email) &&
                Objects.equals(phoneNumber, userEntity.phoneNumber) &&
                Objects.equals(salt, userEntity.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, name, surname, email, phoneNumber, salt);
    }

    @OneToMany(
            mappedBy = "unitEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> userReviews) {
        this.reviews = userReviews;
    }
}
