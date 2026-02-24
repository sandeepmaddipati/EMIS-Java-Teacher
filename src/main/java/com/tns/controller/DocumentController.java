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
import com.tns.dto.DocumentRequest;
import com.tns.dto.DocumentResponse;
import com.tns.service.DocumentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/documents")
public class DocumentController{
	
	@Autowired
	private DocumentService service;
	
	@PostMapping("/saveOrUpdate")
	
	public ApiResponse<DocumentResponse> saveOrUpdate(@Valid @RequestBody DocumentRequest request){
		
		return service.saveOrUpdate(request);
	}
	
	@GetMapping("/{userId}")
	
	public ApiResponse <List<DocumentResponse>> getByUserId(@PathVariable Long userId ){
		List<DocumentResponse> responseList= service.getByUserId(userId);
		if(responseList.isEmpty()) {
			 return new ApiResponse<>(404, "No documents found for this user", null);
        }
        return new ApiResponse<>(200, "Documents retrieved successfully", responseList);

	}
}