package com.blueground.assignment.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ReviewEntityPK implements Serializable {

    @ManyToOne
    private UnitEntity unitEntity;
    @ManyToOne
    private UserEntity userEntity;

    public UnitEntity getUnitEntity() {
        return unitEntity;
    }

    public void setUnitEntity(UnitEntity unitEntity) {
        this.unitEntity = unitEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ReviewEntityPK() {
    }


}
