package com.example.toamto.controller;

import com.example.toamto.mapper.UserMapper;
import com.example.toamto.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    PasswordEncoder passwordEncoder;
    @Resource
    UserMapper userMapper;

    @GetMapping("/register")
    public User register(){
        User user = new User();
        user.setUsername("xds1");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRole("normal");
        userMapper.insert(user);
        return user;
    }
}
