package com.blueground.assignment.service;

import org.springframework.stereotype.Service;

@Service
public interface UserServiceApi {

    String login(String username, String password);


}
