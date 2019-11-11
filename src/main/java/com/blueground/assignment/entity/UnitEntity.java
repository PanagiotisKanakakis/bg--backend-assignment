package com.blueground.assignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Unit")
public class UnitEntity {
    private Integer unitId;
    private Integer price;
    private String title;
    private String description;
    private String region;
    private String cancellationPolicy;
    private List<PhotosEntity> photos;
    private List<ReviewEntity> reviews;

    @Id
    @Column(name = "UNIT_ID", nullable = false)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "PRICE", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "REGION", nullable = false, length = 45)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "CANCELLATION_POLICY", nullable = true, length = 200)
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitEntity unitEntity = (UnitEntity) o;
        return Objects.equals(unitId, unitEntity.unitId) &&
                Objects.equals(price, unitEntity.price) &&
                Objects.equals(title, unitEntity.title) &&
                Objects.equals(description, unitEntity.description) &&
                Objects.equals(region, unitEntity.region) &&
                Objects.equals(cancellationPolicy, unitEntity.cancellationPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitId, price, title, description, region, cancellationPolicy);
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<PhotosEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosEntity> photosEntityByUnitId) {
        this.photos = photosEntityByUnitId;
    }

    @OneToMany(
            mappedBy = "userEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
}
