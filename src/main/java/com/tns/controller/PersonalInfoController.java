package com.tns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.ApiResponse;
import com.tns.dto.PersonalInfoRequest;
import com.tns.dto.PersonalInfoResponse;
import com.tns.service.PersonalInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/personal-info")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService service;

    // ✅ Create or Update personal info
    @PostMapping("/saveOrUpdate")
    public ApiResponse<PersonalInfoResponse> saveOrUpdate(@Valid @RequestBody PersonalInfoRequest request) {
        return service.saveOrUpdate(request);
    }

    // ✅ Fetch personal info by userId
    @GetMapping("/{userId}")
    public ApiResponse<PersonalInfoResponse> getByUserId(@PathVariable Long userId) {
        return service.getByUserId(userId)
                .map(res -> new ApiResponse<>(200, "Personal info retrieved successfully", res))
                .orElse(new ApiResponse<>(404, "Personal info not found", null));
    }
}
