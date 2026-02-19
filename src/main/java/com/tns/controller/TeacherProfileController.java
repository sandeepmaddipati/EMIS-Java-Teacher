package com.tns.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.TeacherProfileRequest;
import com.tns.service.TeacherProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teacher/profile")
public class TeacherProfileController {

    @Autowired
    private TeacherProfileService service;

    @PostMapping
    public ResponseEntity<String> saveOrUpdate(
            @Valid @RequestBody TeacherProfileRequest request){
        return ResponseEntity.ok(service.saveOrUpdate(request));
    }
}

