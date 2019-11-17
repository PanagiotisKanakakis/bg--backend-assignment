package com.blueground.assignment.mapper;

import com.blueground.assignment.dto.UnitResponseDto;
import com.blueground.assignment.entity.UnitEntity;
import org.springframework.stereotype.Component;

@Component
public class UnitMapper {

    public UnitResponseDto toUnitResponseDTO(UnitEntity unitEntity) {
        return new UnitResponseDto().setCancellationPolicy(unitEntity.getCancellationPolicy())
                .setDescription(unitEntity.getDescription())
                .setPhotos(unitEntity.getPhotos())
                .setPrice(unitEntity.getPrice())
                .setRegion(unitEntity.getRegion())
                .setTitle(unitEntity.getTitle())
                .setUnitId(unitEntity.getUnitId());
    }

}
