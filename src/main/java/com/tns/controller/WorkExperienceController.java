package com.tns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.ApiResponse;
import com.tns.dto.WorkExperienceRequest;
import com.tns.dto.WorkExperienceResponse;
import com.tns.service.WorkExperienceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/work-experiences")

public class WorkExperienceController{
	
	@Autowired
	private WorkExperienceService service;


@PostMapping("/saveOrUpdate")
public ApiResponse<WorkExperienceResponse> saveOrUpdate (@Valid @RequestBody WorkExperienceRequest request){
	
	return service.saveOrUpdate(request);
}

@GetMapping("/{userId}")

public ApiResponse <List<WorkExperienceResponse> > getByUserId(@PathVariable Long userId){
	 List<WorkExperienceResponse> responseList = service.getByUserId(userId);
     if (responseList.isEmpty()) {
         return new ApiResponse<>(404, "No work experiences found for this user", null);
     }
     return new ApiResponse<>(200, "Work experiences retrieved successfully", responseList);

	
}
}