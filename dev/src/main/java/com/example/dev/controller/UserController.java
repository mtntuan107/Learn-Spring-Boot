package com.example.dev.controller;

import com.example.dev.dto.request.ApiResponse;
import com.example.dev.dto.request.UserCreateRequest;
import com.example.dev.dto.request.UserUpdateRequest;
import com.example.dev.dto.response.UserResponse;
import com.example.dev.entity.User;
import com.example.dev.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        apiResponse.setCode(201);
        apiResponse.setMessage("Success create");
        return apiResponse;
    }

    @GetMapping
    List<User> listUser(){
        return userService.listUser();
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@RequestBody UserUpdateRequest request, @PathVariable("userId") String id){
        return userService.updateUser(request, id);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String id){
        return userService.deleteUser(id);
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String id){
        return userService.getUser(id);
    }
}
