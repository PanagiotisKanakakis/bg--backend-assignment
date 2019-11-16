package com.blueground.assignment.dao;

import com.blueground.assignment.entity.UnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UnitRepository extends PagingAndSortingRepository<UnitEntity,Integer> {

    Page<UnitEntity> findAllByTitleOrRegion(String price, String region, Pageable pageable);

}
