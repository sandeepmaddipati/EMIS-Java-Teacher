package com.tns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.AcademicQualificationRequest;
import com.tns.dto.AcademicQualificationResponse;
import com.tns.dto.ApiResponse;
import com.tns.service.AcademicQualificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/academic-qualifications")

public class AcademicQualificationController {

    @Autowired
    private AcademicQualificationService service;
    


@PostMapping("/saveOrUpdate")
public ApiResponse<AcademicQualificationResponse> saveOrUpdate(
        @Valid @RequestBody AcademicQualificationRequest request) {
    return service.saveOrUpdate(request);
}

@GetMapping("/{userId}")
public ApiResponse<List<AcademicQualificationResponse>> getByUserId(@PathVariable Long userId) {
    List<AcademicQualificationResponse> responseList = service.getByUserId(userId);
    if (responseList.isEmpty()) {
        return new ApiResponse<>(404, "No academic qualifications found for this user", null);
    }
    return new ApiResponse<>(200, "Academic qualifications retrieved successfully", responseList);
}
}