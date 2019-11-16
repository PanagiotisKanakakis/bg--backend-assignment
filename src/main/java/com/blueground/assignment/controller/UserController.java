package com.blueground.assignment.controller;

import com.blueground.assignment.dto.UserResponseDTO;
import com.blueground.assignment.exception.RestException;
import com.blueground.assignment.service.UserServiceApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceApi userServiceApi;

    @GetMapping(path = "/login")
    String login(@ApiParam(value = "Username", required = true) @RequestParam("username") String username,
                 @ApiParam(value = "Password", required = true) @RequestParam("password") String password) throws RestException {
        return userServiceApi.login(username, password);
    }


    @PostMapping(path = "/review")
    @PreAuthorize("hasRole('ROLE_USER')")
    UserResponseDTO review(@ApiParam(value = "Username", required = true) @PathVariable String username,
                           @ApiParam(value = "Unit id", required = true) @PathVariable Integer unitId,
                           @ApiParam(value = "Rate", required = true) @PathVariable Integer rate,
                           @ApiParam(value = "Comment", required = true) @PathVariable String comment) throws RestException {
        return userServiceApi.review(username,unitId,rate,comment);
    }


}
