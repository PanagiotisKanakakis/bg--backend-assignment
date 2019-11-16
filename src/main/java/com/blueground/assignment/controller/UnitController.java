package com.blueground.assignment.controller;

import com.blueground.assignment.dao.UnitRepository;
import com.blueground.assignment.entity.UnitEntity;
import com.blueground.assignment.exception.RestException;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unit")
public class UnitController {

    @Autowired
    UnitRepository unitRepository;

    @GetMapping(path = "/getAll")
    @PreAuthorize("hasRole('ROLE_USER')")
    Page<UnitEntity> getByPage(@ApiParam(value = "Page", required = true) @RequestParam("page") Integer page,
                               @ApiParam(value = "Size", required = true) @RequestParam("size") Integer size) throws RestException{
        Pageable pageRequest = new PageRequest(
                ((page == null) ? 0 : (page - 1)),
                ((size == null) ? 10 : size));
        return unitRepository.findAll(pageRequest);
    }


    @GetMapping(path = "/search")
    @PreAuthorize("hasRole('ROLE_USER')")
    Page<UnitEntity> search(@ApiParam(value = "Region", required = true) @RequestParam("region") String region,
                            @ApiParam(value = "Price", required = true) @RequestParam("price") String price,
                            @ApiParam(value = "Page", required = true) @RequestParam("page") Integer page,
                            @ApiParam(value = "Size", required = true) @RequestParam("size") Integer size) throws RestException{
        Pageable pageRequest = new PageRequest(
                ((page == null) ? 0 : (page - 1)),
                ((size == null) ? 10 : size));
        return unitRepository.findAllByTitleOrRegion(price,region,pageRequest);
    }

}
