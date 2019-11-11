package com.blueground.assignment.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Photos")
public class PhotosEntity {
    private Integer photoId;
    private String path;
    private Integer unitId;

    @Id
    @Column(name = "PHOTO_ID", nullable = false)
    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "PATH", nullable = false, length = 45)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "UNIT_ID", nullable = false)
    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotosEntity photosEntity = (PhotosEntity) o;
        return Objects.equals(photoId, photosEntity.photoId) &&
                Objects.equals(path, photosEntity.path) &&
                Objects.equals(unitId, photosEntity.unitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, path, unitId);
    }


}
