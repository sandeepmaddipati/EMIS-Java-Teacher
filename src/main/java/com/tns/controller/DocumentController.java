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

import com.tns.dto.DocumentRequest;
import com.tns.dto.DocumentResponse;
import com.tns.service.DocumentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired private DocumentService service;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<String> saveOrUpdate(@Valid @RequestBody DocumentRequest req) {
        return ResponseEntity.ok(service.saveOrUpdate(req));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<DocumentResponse>> getAllByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(service.getAllByTeacher(teacherId));
    }
}
