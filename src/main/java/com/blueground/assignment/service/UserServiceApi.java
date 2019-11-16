package com.blueground.assignment.service;

import com.blueground.assignment.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceApi {

    String login(String username, String password);


    UserResponseDTO review(String username, Integer unitId, Integer rate, String comment);
}
