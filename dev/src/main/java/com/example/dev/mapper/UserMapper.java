package com.example.dev.mapper;

import com.example.dev.dto.request.UserCreateRequest;
import com.example.dev.dto.request.UserUpdateRequest;
import com.example.dev.dto.response.UserResponse;
import com.example.dev.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);
    void updateUser(UserUpdateRequest request, @MappingTarget User user);
    UserResponse toUserResponse (User user);
}
