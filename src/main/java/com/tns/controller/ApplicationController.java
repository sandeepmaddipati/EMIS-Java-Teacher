package com.tns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.service.ApplicationService;

@RestController
@RequestMapping("/api/teacher/application")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @PostMapping("/submit/{userId}")
    public ResponseEntity<String> submit(
            @PathVariable Long userId){

        return ResponseEntity.ok(
                service.submitApplication(userId));
    }
}
