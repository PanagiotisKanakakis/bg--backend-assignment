package com.blueground.assignment.mapper;

import com.blueground.assignment.dto.UserResponseDto;
import com.blueground.assignment.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toUserResponseDto(UserEntity userEntity) {
        return new UserResponseDto().setEmail(userEntity.getEmail())
                .setPhoneNumber(userEntity.getPhoneNumber())
                .setReviews(userEntity.getReviews())
                .setUsername(userEntity.getUsername())
                .setName(userEntity.getName())
                .setSurName(userEntity.getSurname());
    }
}
