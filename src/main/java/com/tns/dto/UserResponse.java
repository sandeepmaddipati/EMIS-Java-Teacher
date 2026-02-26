package com.tns.dto;

import java.util.List;

public class UserResponse {

    private Long userId;
    private String fullname;
    private String email;
    private String phone;
    private Boolean isActive;
    private List<String> roles;  // ✅ multiple roles supported

    public UserResponse() {}

    public UserResponse(Long userId, String fullname, String email, String phone, Boolean isActive, List<String> roles) {
        this.userId = userId;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
        this.roles = roles;
    }

    // --- Getters & Setters ---
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }
}