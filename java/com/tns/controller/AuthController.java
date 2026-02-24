package com.tns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.ApiResponse;
import com.tns.dto.LoginRequest;
import com.tns.dto.RegisterRequest;
import com.tns.dto.UserResponse;
import com.tns.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody RegisterRequest request) {
        UserResponse user = authService.register(request);
        return ResponseEntity.status(201)
                .body(new ApiResponse<>(201, "User Registered Successfully with role: " + user.getRoles().get(0), user));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponse>> login(@Valid @RequestBody LoginRequest request) {
        UserResponse user = authService.login(request);
        return ResponseEntity.ok(
                new ApiResponse<>(200, "Login Successful", user));
    }
    
    @GetMapping("/users")
    public ApiResponse<List<UserResponse>> getAllUsers() {
        return authService.getAllUsersWithRoles();
    }
    
}
