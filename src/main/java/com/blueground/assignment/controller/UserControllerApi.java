package com.blueground.assignment.controller;

import com.blueground.assignment.dto.UserRequestDTO;
import com.blueground.assignment.dto.UserResponseDTO;
import com.blueground.assignment.exception.RestException;

public interface UserControllerApi {

    UserResponseDTO login(UserRequestDTO userRequestDTO) throws RestException;


}
