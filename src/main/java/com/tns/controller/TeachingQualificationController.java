	package com.tns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tns.dto.TeachingQualificationRequest;
import com.tns.dto.TeachingQualificationResponse;
import com.tns.service.TeachingQualificationService;

@RestController
@RequestMapping("/api/teaching-qualifications")
public class TeachingQualificationController {

    @Autowired
    private TeachingQualificationService qualificationService;

    // Save or Update
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<String> saveOrUpdate(
            @RequestBody TeachingQualificationRequest request) {
        String response = qualificationService.saveOrUpdate(request);
        return ResponseEntity.ok(response);
    }

    // Get all qualifications for a teacher
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<TeachingQualificationResponse>> getAllByTeacher(@PathVariable Long teacherId) {
        List<TeachingQualificationResponse> responses = qualificationService.getAllByTeacher(teacherId);
        return ResponseEntity.ok(responses);
    }
}