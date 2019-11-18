package com.blueground.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
@AssociationOverrides({
        @AssociationOverride(name = "reviewEntityPK.userEntity",
                joinColumns = @JoinColumn(name = "USERNAME")),
        @AssociationOverride(name = "reviewEntityPK.unitEntity",
                joinColumns = @JoinColumn(name = "UNIT_ID"))})
public class ReviewEntity implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private ReviewEntityPK reviewEntityPK = new ReviewEntityPK();

    @Basic
    @Column(name = "REVIEW", length = 200)
    private String review;
    @Basic
    @Column(name = "SCORE")
    private Integer score;

    public ReviewEntityPK getReviewEntityPK() {
        return reviewEntityPK;
    }

    public void setReviewEntityPK(ReviewEntityPK reviewEntityPK) {
        this.reviewEntityPK = reviewEntityPK;
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
