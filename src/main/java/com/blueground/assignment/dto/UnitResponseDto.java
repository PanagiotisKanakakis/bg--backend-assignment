package com.blueground.assignment.dto;

import com.blueground.assignment.entity.PhotosEntity;

import java.util.List;

public class UnitResponseDto {
    private Integer unitId;
    private Integer price;
    private String title;
    private String description;
    private String region;
    private String cancellationPolicy;
    private List<PhotosEntity> photos;

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
}
