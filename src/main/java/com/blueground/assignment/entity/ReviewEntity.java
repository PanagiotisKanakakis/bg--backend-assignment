package com.blueground.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Review")
public class ReviewEntity implements Serializable {

    @EmbeddedId
    private ReviewEntityPK id;
    @Basic
    @Column(name = "REVIEW", nullable = true, length = 200)
    private String review;
    @Basic
    @Column(name = "SCORE", nullable = true)
    private Integer score;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("UNIT_ID")
    @JsonIgnore
    private UnitEntity unitEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("USERNAME")
    @JsonIgnore
    private UserEntity userEntity;

    public ReviewEntityPK getId() {
        return id;
    }

    public void setId(ReviewEntityPK id) {
        this.id = id;
    }

    public UnitEntity getUnitEntity() {
        return unitEntity;
    }

    public void setUnitEntity(UnitEntity unitEntity) {
        this.unitEntity = unitEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
