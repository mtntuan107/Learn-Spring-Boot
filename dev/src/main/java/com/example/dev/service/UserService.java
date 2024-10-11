package com.example.dev.service;

import com.example.dev.dto.request.UserCreateRequest;
import com.example.dev.dto.request.UserUpdateRequest;
import com.example.dev.dto.response.UserResponse;
import com.example.dev.entity.User;
import com.example.dev.exception.AppException;
import com.example.dev.exception.ErrorCode;
import com.example.dev.mapper.UserMapper;
import com.example.dev.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository ;
    UserMapper userMapper;
    public User createUser(UserCreateRequest request){
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public UserResponse updateUser(UserUpdateRequest request, String id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        userMapper.updateUser(request, user);

        return userMapper.toUserResponse(userRepository.save(user));
    }
    public String deleteUser(String id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException(("user not found")));
        userRepository.delete(user);
        return "Delete user success";
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(()-> new RuntimeException(("user not found"))));

    }
}
