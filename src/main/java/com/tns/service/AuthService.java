package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tns.dto.ApiResponse;
import com.tns.dto.LoginRequest;
import com.tns.dto.RegisterRequest;
import com.tns.dto.UserResponse;
import com.tns.model.Role;
import com.tns.model.User;
import com.tns.model.UserRole;
import com.tns.repository.RoleRepository;
import com.tns.repository.UserRepository;
import com.tns.repository.UserRoleRepository;

@Service
public class AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private UserRoleRepository userRoleRepository;
    @Autowired private BCryptPasswordEncoder encoder;

    public UserResponse register(RegisterRequest request) {
        if (userRepository.findByFullname(request.getFullname()).isPresent()) {
            throw new RuntimeException("Name already exists");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Role role = roleRepository.findByRoleName(request.getRoleName())
                .orElseThrow(() -> new RuntimeException("Invalid role provided"));

        User user = new User();
        user.setFullname(request.getFullname().trim());

        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setIsActive(true);

        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);

        // Build DTO
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setFullname(user.getFullname());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setIsActive(user.getIsActive());
        response.setRoles(List.of(role.getRoleName()));

        return response;
    }

    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getIsActive()) {
            throw new RuntimeException("User account is inactive");
        }
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        List<String> roles = userRoleRepository.findByUser_UserId(user.getUserId())
                .stream()
                .map(ur -> ur.getRole().getRoleName())
                .toList();

        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setFullname(user.getFullname());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setIsActive(user.getIsActive());
        response.setRoles(roles);

        return response;
    }
    
    public ApiResponse<List<UserResponse>> getAllUsersWithRoles() {
        List<User> users = userRepository.findAll();

        List<UserResponse> responses = users.stream().map(user -> {
            List<String> roles = userRoleRepository.findByUser_UserId(user.getUserId())
                    .stream()
                    .map(ur -> ur.getRole().getRoleName())
                    .toList();

            UserResponse response = new UserResponse();
            response.setUserId(user.getUserId());
            response.setFullname(user.getFullname());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            response.setIsActive(user.getIsActive());
            response.setRoles(roles);

            return response;
        }).toList();

        return new ApiResponse<>(200, "Fetched all users successfully", responses);
    }

}