package com.tns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.TeacherProfileRequest;
import com.tns.dto.TeacherProfileResponse;
import com.tns.service.TeacherProfileService;

@RestController
@RequestMapping("/api/teacher/profile")
public class TeacherProfileController {
@Autowired
    private  TeacherProfileService service;

   

@PostMapping("/saveOrUpdate")
public ResponseEntity<String> saveOrUpdate(@RequestBody TeacherProfileRequest req) {
    return ResponseEntity.ok(service.saveOrUpdate(req));
}

@GetMapping("/user/{userId}")
public ResponseEntity<TeacherProfileResponse> getByUser(@PathVariable Long userId) {
    return ResponseEntity.ok(service.getByUser(userId));
}
}