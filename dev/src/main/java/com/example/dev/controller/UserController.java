package com.example.dev.controller;

import com.example.dev.dto.request.UserCreateRequest;
import com.example.dev.dto.request.UserUpdateRequest;
import com.example.dev.entity.User;
import com.example.dev.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreateRequest request){ //Valid kiem tra xem co dung nhu size ko
        return userService.createUser(request);
    }

    @GetMapping
    List<User> listUser(){
        return userService.listUser();
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest request, @PathVariable("userId") String id){
        return userService.updateUser(request, id);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String id){
        return userService.deleteUser(id);
    }
}
