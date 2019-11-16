package com.blueground.assignment.controller;

import com.blueground.assignment.entity.UnitEntity;
import com.blueground.assignment.exception.RestException;
import com.blueground.assignment.service.UnitServiceApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unit")
public class UnitController {

    @Autowired
    UnitServiceApi unitServiceApi;


    @GetMapping(path = "/getAll")
    @PreAuthorize("hasRole('ROLE_USER')")
    Page<UnitEntity> getByPage(@ApiParam(value = "Page", required = true) @RequestParam("page") Integer page,
                               @ApiParam(value = "Size", required = true) @RequestParam("size") Integer size) throws RestException {
        return unitServiceApi.getByPage(page, size);
    }


    @GetMapping(path = "/search")
    @PreAuthorize("hasRole('ROLE_USER')")
    Page<UnitEntity> search(@ApiParam(value = "Region", required = true) @RequestParam("region") String region,
                            @ApiParam(value = "Price", required = true) @RequestParam("price") String price,
                            @ApiParam(value = "Page", required = true) @RequestParam("page") Integer page,
                            @ApiParam(value = "Size", required = true) @RequestParam("size") Integer size) throws RestException {

        return unitServiceApi.search(page, size, region, price);
    }

}
