	package com.tns.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.LoginRequest;
import com.tns.dto.RegisterRequest;
import com.tns.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")

public class UserController {
@Autowired
     private  UserService service;



    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        return service.register(request);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {
        return service.login(request);
    }
    
    
}
