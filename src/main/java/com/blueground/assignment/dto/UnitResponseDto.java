package com.blueground.assignment.dto;

import com.blueground.assignment.entity.PhotosEntity;
import com.blueground.assignment.entity.ReviewEntity;

import java.util.List;
import java.util.Set;

public class UnitResponseDto {
    private Integer unitId;
    private Integer price;
    private String title;
    private String description;
    private String region;
    private String cancellationPolicy;
    private double averageScore;
    private List<PhotosEntity> photos;
    private Set<ReviewEntity> reviews;

    public UnitResponseDto() {
    }

    public Integer getUnitId() {
        return unitId;
    }

    public UnitResponseDto setUnitId(Integer unitId) {
        this.unitId = unitId;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public UnitResponseDto setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UnitResponseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UnitResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public UnitResponseDto setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public UnitResponseDto setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
        return this;
    }

    public List<PhotosEntity> getPhotos() {
        return photos;
    }

    public UnitResponseDto setPhotos(List<PhotosEntity> photos) {
        this.photos = photos;
        return this;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public UnitResponseDto setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
        return this;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public UnitResponseDto setAverageScore(double averageScore) {
        this.averageScore = averageScore;
        return this;
    }
}
