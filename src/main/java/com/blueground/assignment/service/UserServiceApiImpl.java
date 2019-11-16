package com.blueground.assignment.service;

import com.blueground.assignment.config.JwtTokenProvider;
import com.blueground.assignment.dao.UserRepository;
import com.blueground.assignment.dto.UserResponseDTO;
import com.blueground.assignment.entity.ReviewEntity;
import com.blueground.assignment.entity.UserEntity;
import com.blueground.assignment.exception.CustomException;
import com.blueground.assignment.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceApiImpl implements UserServiceApi {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username);
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Override
    public UserResponseDTO review(String username, Integer unitId, Integer rate, String comment) {
        UserEntity userEntity = userRepository.findOne(username);
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setScore(rate);
        reviewEntity.setReview(comment);
        reviewEntity.setUserEntity(userEntity);
        userEntity.getReviews().add(reviewEntity);
        userRepository.save(userEntity);
        return userMapper.toUserResponseDto(userEntity);
    }
}
