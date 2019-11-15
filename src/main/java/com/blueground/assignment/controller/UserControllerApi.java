package com.blueground.assignment.controller;

import com.blueground.assignment.exception.RestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserControllerApi {

    @GetMapping(path = "/login")
    String login(@RequestParam("username") String username,
                 @RequestParam("password") String password) throws RestException;


}
