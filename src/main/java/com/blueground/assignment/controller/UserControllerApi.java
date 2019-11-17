package com.blueground.assignment.controller;

import com.blueground.assignment.exception.RestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public interface UserControllerApi {

    @PostMapping(path = "/login")
    String login(String username,
                 String password) throws RestException;

}
