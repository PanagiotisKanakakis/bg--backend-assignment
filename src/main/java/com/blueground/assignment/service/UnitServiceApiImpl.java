package com.blueground.assignment.service;

import com.blueground.assignment.dao.UnitRepository;
import com.blueground.assignment.entity.UnitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UnitServiceApiImpl implements UnitServiceApi {

    @Autowired
    UnitRepository unitRepository;

    @Override
    public Page<UnitEntity> getByPage(Integer page, Integer size) {
        Pageable pageRequest = new PageRequest(
                ((page == null) ? 0 : (page - 1)),
                ((size == null) ? 10 : size));
        return unitRepository.findAll(pageRequest);
    }

    @Override
    public Page<UnitEntity> search(Integer page, Integer size, String region, String price) {
        Pageable pageRequest = new PageRequest(
                ((page == null) ? 0 : (page - 1)),
                ((size == null) ? 10 : size));
        return unitRepository.findAllByTitleOrRegion(price,region,pageRequest);
    }
}
