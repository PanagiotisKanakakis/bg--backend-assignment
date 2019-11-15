package com.blueground.assignment.controller;

import com.blueground.assignment.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserControllerApiImpl implements UserControllerApi {

    @Autowired
    UserServiceApi userServiceApi;


    @Override
    public String login(String username,
                        String password) {
        return userServiceApi.login(username, password);
    }


}
