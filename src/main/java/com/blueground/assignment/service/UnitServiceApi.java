package com.blueground.assignment.service;

import com.blueground.assignment.dto.UnitResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UnitServiceApi {
    Page<UnitResponseDto> getByPage(Integer page, Integer size);

    Page<UnitResponseDto> search(Integer page, Integer size, String region, String title);

    UnitResponseDto review(String username, Integer unitId, Integer rate, String comment);
}
