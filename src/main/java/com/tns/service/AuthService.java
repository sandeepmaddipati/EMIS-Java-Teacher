package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private UserRoleRepository userRoleRepository;
    @Autowired private BCryptPasswordEncoder encoder;

    // ================= REGISTER =================
    public UserResponse register(RegisterRequest request) {

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

        return buildUserResponse(user, List.of(role.getRoleName()));
    }

    // ================= LOGIN =================
    public UserResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!user.getIsActive()) {
            throw new RuntimeException("User account is inactive");
        }

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        List<String> roles = user.getUserRoles()
                .stream()
                .map(ur -> ur.getRole().getRoleName())
                .toList();

        return buildUserResponse(user, roles);
    }

    // ================= GET ALL USERS =================
    public ApiResponse<List<UserResponse>> getAllUsersWithRoles() {

        List<User> users = userRepository.findAllWithRoles();

        List<UserResponse> responses = users.stream()
                .map(user -> {
                    List<String> roles = user.getUserRoles()
                            .stream()
                            .map(ur -> ur.getRole().getRoleName())
                            .toList();

                    return buildUserResponse(user, roles);
                })
                .toList();

        return new ApiResponse<>(200, "Fetched all users successfully", responses);
    }

    // ================= COMMON DTO BUILDER =================
    private UserResponse buildUserResponse(User user, List<String> roles) {

        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setFullname(user.getFullname());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setIsActive(user.getIsActive());
        response.setRoles(roles);

        return response;
    }
}