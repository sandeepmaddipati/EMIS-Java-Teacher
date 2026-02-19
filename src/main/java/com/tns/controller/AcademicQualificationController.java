package com.tns.controller;

import com.tns.dto.AcademicQualificationRequest;
import com.tns.service.AcademicQualificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher/academic")
public class AcademicQualificationController {

    @Autowired
    private AcademicQualificationService service;

    @PostMapping
    public ResponseEntity<String> saveOrUpdate(
            @Valid @RequestBody AcademicQualificationRequest request){

        return ResponseEntity.ok(service.saveOrUpdate(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAll(@PathVariable Long userId){
        return ResponseEntity.ok(service.getAllByUserId(userId));
    }
}
