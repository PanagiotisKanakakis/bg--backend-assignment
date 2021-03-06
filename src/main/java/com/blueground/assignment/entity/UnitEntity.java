package com.blueground.assignment.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "unit")
public class UnitEntity {
    @Id
    @Column(name = "UNIT_ID", nullable = false)
    private Integer unitId;
    @Basic
    @Column(name = "PRICE", nullable = false)
    private Integer price;
    @Basic
    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;
    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    private String description;
    @Basic
    @Column(name = "REGION", nullable = false, length = 45)
    private String region;
    @Basic
    @Column(name = "CANCELLATION_POLICY", length = 200)
    private String cancellationPolicy;
    @Basic
    @Column(name = "AVERAGE_SCORE")
    private Double averageScore;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PhotosEntity> photos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewEntityPK.unitEntity", cascade=CascadeType.ALL)
    private Set<ReviewEntity> reviews = new HashSet<>();


    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public List<PhotosEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosEntity> photosEntityByUnitId) {
        this.photos = photosEntityByUnitId;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }
}
