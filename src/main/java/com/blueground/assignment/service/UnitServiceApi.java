package com.blueground.assignment.service;

import com.blueground.assignment.entity.UnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UnitServiceApi {
    Page<UnitEntity> getByPage(Integer page, Integer size);

    Page<UnitEntity> search(Integer page, Integer size, String region, String price);
}
