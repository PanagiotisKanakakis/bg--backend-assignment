package com.blueground.assignment.controller;

import com.blueground.assignment.dto.UnitResponseDto;
import com.blueground.assignment.exception.RestException;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UnitControllerApi {

    @GetMapping(path = "/units")
    @PreAuthorize("hasRole('ROLE_USER')")
    Page<UnitResponseDto> getByPage(Integer page,
                                    Integer size) throws RestException;


    @GetMapping(path = "/units/search")
    @PreAuthorize("hasRole('ROLE_USER')")
    Page<UnitResponseDto> search(String region,
                                 String price,
                                 Integer page,
                                 Integer size) throws RestException;

    @PostMapping(path = "/unit/review")
    @PreAuthorize("hasRole('ROLE_USER')")
    UnitResponseDto review(String username,
                           Integer unitId,
                           Integer rate,
                           String comment) throws RestException;

}
