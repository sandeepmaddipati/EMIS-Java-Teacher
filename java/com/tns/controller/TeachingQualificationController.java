package com.tns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.ApiResponse;
import com.tns.dto.TeachingQualificationRequest;
import com.tns.dto.TeachingQualificationResponse;
import com.tns.service.TeachingQualificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teaching-qualifications")
public class TeachingQualificationController {

    @Autowired
    private TeachingQualificationService service;

    @PostMapping("/saveOrUpdate")
    public ApiResponse<TeachingQualificationResponse> saveOrUpdate(
            @Valid @RequestBody TeachingQualificationRequest request) {
        return service.saveOrUpdate(request);
    }

    @GetMapping("/{userId}")
    public ApiResponse<List<TeachingQualificationResponse>> getByUserId(@PathVariable Long userId) {
        List<TeachingQualificationResponse> responseList = service.getByUserId(userId);
        if (responseList.isEmpty()) {
            return new ApiResponse<>(404, "No teaching qualifications found for this user", null);
        }
        return new ApiResponse<>(200, "Teaching qualifications retrieved successfully", responseList);
    }
}