package com.example.dev.service;

import com.example.dev.dto.request.UserCreateRequest;
import com.example.dev.dto.request.UserUpdateRequest;
import com.example.dev.entity.User;
import com.example.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ;
    public User createUser(UserCreateRequest request){
        User user = new User();
        //Neu trung username se nem ra 1 ngoai le voi message nhu duoi

        if(userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("User existed");

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public User updateUser(UserUpdateRequest request, String id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if(request.getPassword() != null)
            user.setPassword(request.getPassword());
        if(request.getFirstname() !=null)
            user.setFirstname(request.getFirstname());
        if(request.getLastname()!=null)
            user.setLastname(request.getLastname());
        if(request.getDob()!=null)
            user.setDob(request.getDob());

        return userRepository.save(user);
    }
    public String deleteUser(String id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException(("user not found")));
        userRepository.delete(user);
        return "Delete user success";
    }
}
