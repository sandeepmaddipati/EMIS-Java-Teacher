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
import com.tns.dto.ApplicationRequest;
import com.tns.dto.ApplicationResponse;
import com.tns.service.ApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired private ApplicationService service;

    @PostMapping("/submit")
    public ApiResponse<ApplicationResponse> submitApplication(@Valid @RequestBody ApplicationRequest request) {
        return service.submitApplication(request);
    }

    @GetMapping("/{userId}/submitted")
    public ApiResponse<List<ApplicationResponse>> getSubmittedApplications(@PathVariable Long userId) {
        List<ApplicationResponse> responseList = service.getSubmittedApplications(userId);
        if (responseList.isEmpty()) {
            return new ApiResponse<>(404, "No submitted applications found", null);
        }
        return new ApiResponse<>(200, "Submitted applications retrieved successfully", responseList);
    }

    @GetMapping("/{userId}/all")
    public ApiResponse<List<ApplicationResponse>> getAllApplications(@PathVariable Long userId) {
        List<ApplicationResponse> responseList = service.getAllApplications(userId);
        if (responseList.isEmpty()) {
            return new ApiResponse<>(404, "No applications found", null);
        }
        return new ApiResponse<>(200, "All applications retrieved successfully", responseList);
    }
}