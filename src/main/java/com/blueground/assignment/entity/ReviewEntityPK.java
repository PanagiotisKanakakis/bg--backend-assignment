package com.blueground.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReviewEntityPK implements Serializable {

    @Column(name = "USERNAME")
    private String username;
    @Column(name = "UNIT_ID")
    private Integer unitId;

    public ReviewEntityPK() {
    }

    public ReviewEntityPK(String username, Integer unitId) {
        this.username = username;
        this.unitId = unitId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

}
