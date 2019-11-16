package com.blueground.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Review")
public class ReviewEntity implements Serializable {

    private ReviewEntityPK id;
    private String review;
    private Integer score;
    private UnitEntity unitEntity;
    private UserEntity userEntity;

    @EmbeddedId
    public ReviewEntityPK getId() {
        return id;
    }

    public void setId(ReviewEntityPK id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("UNIT_ID")
    @JsonIgnore
    public UnitEntity getUnitEntity() {
        return unitEntity;
    }

    public void setUnitEntity(UnitEntity unitEntity) {
        this.unitEntity = unitEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("USERNAME")
    @JsonIgnore
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    @Basic
    @Column(name = "REVIEW", nullable = true, length = 200)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "SCORE", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewEntity that = (ReviewEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(review, that.review) &&
                Objects.equals(score, that.score) &&
                Objects.equals(unitEntity, that.unitEntity) &&
                Objects.equals(userEntity, that.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review, score, unitEntity, userEntity);
    }
}
