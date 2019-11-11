package com.blueground.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReviewEntityPK implements Serializable {

    private String username;
    private Integer unitId;

    public ReviewEntityPK() {
    }

    public ReviewEntityPK(String username, Integer unitId) {
        this.username = username;
        this.unitId = unitId;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "UNIT_ID")
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
        ReviewEntityPK that = (ReviewEntityPK) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(unitId, that.unitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, unitId);
    }
}
