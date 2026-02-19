package com.tns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tns.dto.LoginRequest;
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
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 🔹 REGISTER
    public String register(RegisterRequest request) {

        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists";
        }

        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepo.save(user);

        // assign TEACHER role
        Role role = roleRepo.findByRoleName("TEACHER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepo.save(userRole);

        return "Registration successful";
    }

    // 🔹 LOGIN
    public String login(LoginRequest request) {

        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "Invalid Password";
        }

        return "Login Successful";
        
    }
}
