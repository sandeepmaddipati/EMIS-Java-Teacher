package com.tns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.AcademicQualificationRequest;
import com.tns.dto.AcademicQualificationResponse;
import com.tns.service.AcademicQualificationService;

@RestController
@RequestMapping("/api/academic-qualifications")
public class AcademicQualificationController {
    @Autowired
    private AcademicQualificationService service;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<String> saveOrUpdate(@RequestBody AcademicQualificationRequest req) {
        return ResponseEntity.ok(service.saveOrUpdate(req));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<AcademicQualificationResponse>> getAllByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(service.getAllByTeacher(teacherId));
    }
}