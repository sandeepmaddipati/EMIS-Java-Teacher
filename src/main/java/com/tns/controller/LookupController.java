package com.tns.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tns.dto.ApiResponse;
import com.tns.dto.LookupMaster;
import com.tns.dto.LookupValueResponse;
import com.tns.service.LookupService;

@RestController
@RequestMapping("/api/lookups")
public class LookupController {
@Autowired
    private  LookupService lookupService;
@Autowired
private JdbcTemplate jdbcTemplate;

@GetMapping
public ResponseEntity<ApiResponse<List<LookupMaster>>> getAllCategories() {
    List<LookupMaster> categories = lookupService.getLookupMaster();

    ApiResponse<List<LookupMaster>> response;
    if (categories.isEmpty()) {
        response = new ApiResponse<>(404, "No lookup categories found", null);
    } else {
        response = new ApiResponse<>(200, "Lookup categories retrieved successfully", categories);
    }

    return ResponseEntity.ok(response);
}

   
@GetMapping("/{categoryKey}")
public ResponseEntity<ApiResponse<List<LookupValueResponse>>> getLookupValues(
        @PathVariable String categoryKey) {

    List<LookupValueResponse> values = lookupService.getValues(categoryKey);

    ApiResponse<List<LookupValueResponse>> response =
            new ApiResponse<>(200, "Lookup values fetched successfully", values);

    return ResponseEntity.ok(response);
}
//Get subjects by type
@GetMapping("/subject_types/{typeId}/subjects")
public List<LookupValueResponse> getSubjectsByType(@PathVariable Long typeId) {
    return lookupService.getSubjectsByType(typeId);
}



@GetMapping("/test-db")
public List<Map<String,Object>> testDb() {
    return jdbcTemplate.queryForList("SELECT * FROM lookup_categories");
}
}
