package com.blueground.assignment.controller;

import com.blueground.assignment.dao.UserRepository;
import com.blueground.assignment.dto.UserRequestDTO;
import com.blueground.assignment.dto.UserResponseDTO;
import com.blueground.assignment.entity.UserEntity;
import com.blueground.assignment.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserControllerApiImpl implements UserControllerApi {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserResponseDTO login(UserRequestDTO userRequestDTO) {
        Optional<UserEntity> user = userRepository.findById(userRequestDTO.getUsername());
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(userRequestDTO.getUsername());
        }
        return userMapper.toUserResponseDto(user.get());
    }


}
