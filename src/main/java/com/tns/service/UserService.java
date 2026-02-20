package com.tns.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tns.dto.LoginRequest;
import com.tns.dto.LoginResponse;
import com.tns.dto.RegisterRequest;
import com.tns.model.Role;
import com.tns.model.User;
import com.tns.model.UserRole;
import com.tns.repository.RoleRepository;
import com.tns.repository.UserRepository;
import com.tns.repository.UserRoleRepository;

@Service
public class UserService {
@Autowired
    private  UserRepository userRepo;
@Autowired
    private  RoleRepository roleRepo;
@Autowired
    private  UserRoleRepository userRoleRepo;
@Autowired
    private  PasswordEncoder passwordEncoder;


    public String register(RegisterRequest request) {

        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));
        user.setIsActive(true);
        user.setCreatedAt(LocalDateTime.now());

        userRepo.save(user);

        Role role = roleRepo.findByRoleName(
                request.getRoleName())
                .orElseThrow(() ->
                        new RuntimeException("Role not found"));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepo.save(userRole);

        return "User registered successfully";
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        UserRole userRole = user.getUserRoles().get(0);

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setRole(userRole.getRole().getRoleName());

        return response;
    }
}