package com.blueground.assignment.controller;

import com.blueground.assignment.exception.RestException;
import com.blueground.assignment.service.UserServiceApi;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserControllerApiImpl implements UserControllerApi{

    @Autowired
    UserServiceApi userServiceApi;

    public String login(@ApiParam(value = "Username", required = true) @RequestParam("username") String username,
                        @ApiParam(value = "Password", required = true) @RequestParam("password") String password) throws RestException {
        return userServiceApi.login(username, password);
    }
}
