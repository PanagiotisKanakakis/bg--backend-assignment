package com.blueground.assignment.service;

import com.blueground.assignment.dto.UserRequestDTO;
import com.blueground.assignment.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceApi {

    UserResponseDTO login(UserRequestDTO userRequestDTO);


}
