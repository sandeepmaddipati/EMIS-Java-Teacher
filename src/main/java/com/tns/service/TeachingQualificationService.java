package com.tns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.ApiResponse;
import com.tns.dto.TeachingQualificationRequest;
import com.tns.dto.TeachingQualificationResponse;
import com.tns.model.LookupCategory;
import com.tns.model.TeachingQualification;
import com.tns.model.User;
import com.tns.repository.LookupCategoryRepository;
import com.tns.repository.TeachingQualificationRepository;

@Service
public class TeachingQualificationService {

    @Autowired
    private TeachingQualificationRepository repository;
    
    @Autowired
    private LookupCategoryRepository categoryRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
   

    private String resolveLookupValue(String categoryKey,Long id) {
        if (id == null) return null;
        LookupCategory category = categoryRepo.findByCategoryKeyAndIsActiveTrue(categoryKey)
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryKey));

        String sql = "SELECT " + category.getValueColumn() +
                     " FROM " + category.getTableName() +
                     " WHERE " + category.getIdColumn() + " = ? AND is_active = true";

        return jdbcTemplate.queryForObject(sql, String.class, id);
    }
    

    // Save or Update
    public ApiResponse<TeachingQualificationResponse> saveOrUpdate(TeachingQualificationRequest request) {
        Optional<TeachingQualification> existing = repository.findByUser_UserId(request.getUserId())
                .stream()
                .filter(q -> q.getCertificationName().equalsIgnoreCase(request.getCertificationName()))
                .findFirst();

        TeachingQualification entity;
        String message;

        if (existing.isPresent()) {
            entity = existing.get();
            message = "Teaching qualification updated successfully";
        } else {
            entity = new TeachingQualification();
            User user=new User();
           user.setUserId(request.getUserId());
           entity.setUser(user);
            message = "Teaching qualification created successfully";
        }

        entity.setCertificationName(request.getCertificationName());
        entity.setCertificationTypeId(request.getCertificationTypeId());
        entity.setInstitutionName(request.getInstitutionName());
        entity.setCountryId(request.getCountryId());
        entity.setYearOfPassing(request.getYearOfPassing());
        entity.setCertificatePath(request.getCertificatePath());

        TeachingQualification saved = repository.save(entity);
        TeachingQualificationResponse response = mapToResponse(saved);

        return new ApiResponse<>(200, message, response);
    }

    // Get All by UserId
    public List<TeachingQualificationResponse> getByUserId(Long userId) {
        return repository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private TeachingQualificationResponse mapToResponse(TeachingQualification entity) {
        TeachingQualificationResponse dto = new TeachingQualificationResponse();
        dto.setTeachingId(entity.getTeachingId());
        dto.setUserId(entity.getUser().getUserId());
       
        dto.setInstitutionName(entity.getInstitutionName());
        dto.setCertificationTypeId(entity.getCertificationTypeId());
        dto.setCountryId(entity.getCountryId());
        dto.setYearOfPassing(entity.getYearOfPassing());
        
        dto.setCertificationType(resolveLookupValue("certification_types",entity.getCertificationTypeId()));
        dto.setCountryName(resolveLookupValue("countries",entity.getCountryId()));
        
        dto.setCertificatePath(entity.getCertificatePath());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}