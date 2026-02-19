package com.tns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.WorkExperienceRequest;
import com.tns.service.WorkExperienceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teacher/work")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService service;

    @PostMapping
    public ResponseEntity<String> saveOrUpdate(
            @Valid @RequestBody WorkExperienceRequest request){

        return ResponseEntity.ok(service.saveOrUpdate(request));
    }
}
