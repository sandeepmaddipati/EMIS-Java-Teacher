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

import com.tns.dto.WorkExperienceRequest;
import com.tns.dto.WorkExperienceResponse;
import com.tns.service.WorkExperienceService;

@RestController
@RequestMapping("/api/work-experiences")
public class WorkExperienceController {
    @Autowired private WorkExperienceService service;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<String> saveOrUpdate(@RequestBody WorkExperienceRequest req) {
        return ResponseEntity.ok(service.saveOrUpdate(req));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<WorkExperienceResponse>> getAllByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(service.getAllByTeacher(teacherId));
    }
}