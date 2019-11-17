package com.blueground.assignment.controller;

import com.blueground.assignment.dto.UnitResponseDto;
import com.blueground.assignment.exception.RestException;
import com.blueground.assignment.service.UnitServiceApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitControllerApiImpl implements UnitControllerApi {

    @Autowired
    UnitServiceApi unitServiceApi;

    @Override
    public Page<UnitResponseDto> getByPage(@ApiParam(value = "Page", required = true) @RequestParam("page") Integer page,
                                           @ApiParam(value = "Size", required = true) @RequestParam("size") Integer size) throws RestException {
        return unitServiceApi.getByPage(page, size);
    }

    @Override
    public Page<UnitResponseDto> search(@ApiParam(value = "Region", required = true) @RequestParam("region") String region,
                                        @ApiParam(value = "Price", required = true) @RequestParam("price") String price,
                                        @ApiParam(value = "Page", required = true) @RequestParam("page") Integer page,
                                        @ApiParam(value = "Size", required = true) @RequestParam("size") Integer size) throws RestException {
        return unitServiceApi.search(page, size, region, price);
    }

    @Override
    public UnitResponseDto review(@ApiParam(value = "Username", required = true) @RequestParam("username") String username,
                                  @ApiParam(value = "Unit id", required = true) @RequestParam("unitId") Integer unitId,
                                  @ApiParam(value = "Rate", required = true) @RequestParam("rate") Integer rate,
                                  @ApiParam(value = "Comment", required = true) @RequestParam("comment") String comment) throws RestException {
        return unitServiceApi.review(username, unitId, rate, comment);
    }
}
