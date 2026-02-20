package com.tns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.ApplicationRequest;
import com.tns.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    @Autowired private ApplicationService service;

    @PostMapping("/submit")
    public ResponseEntity<String> submit(@RequestBody ApplicationRequest req) {
        return ResponseEntity.ok(service.submit(req));
    }
}
