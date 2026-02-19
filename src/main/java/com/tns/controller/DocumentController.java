package com.tns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.DocumentRequest;
import com.tns.service.DocumentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teacher/document")
public class DocumentController {

    @Autowired
    private DocumentService service;

    @PostMapping
    public ResponseEntity<String> saveOrUpdate(
            @Valid @RequestBody DocumentRequest request){
        return ResponseEntity.ok(service.saveOrUpdate(request));
    }
}
