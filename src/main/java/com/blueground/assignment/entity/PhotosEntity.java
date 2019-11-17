package com.blueground.assignment.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Photos")
public class PhotosEntity {

    @Id
    @Column(name = "PHOTO_ID", nullable = false)
    private Integer photoId;
    @Basic
    @Column(name = "PATH", nullable = false, length = 45)
    private String path;
    @Basic
    @Column(name = "UNIT_ID", nullable = false)
    private Integer unitId;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
