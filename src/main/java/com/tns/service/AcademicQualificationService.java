package com.tns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.AcademicQualificationRequest;
import com.tns.dto.AcademicQualificationResponse;
import com.tns.dto.ApiResponse;
import com.tns.model.AcademicQualification;
import com.tns.model.LookupCategory;
import com.tns.model.User;
import com.tns.repository.AcademicQualificationRepository;
import com.tns.repository.LookupCategoryRepository;


@Service
public class AcademicQualificationService {

    @Autowired
    private AcademicQualificationRepository repository;
    
    @Autowired
    private LookupCategoryRepository categoryRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    
    private String resolveLookupValue(String categoryKey, Long id) {
        if (id == null) return null;

        LookupCategory category = categoryRepo.findByCategoryKeyAndIsActiveTrue(categoryKey)
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryKey));

        String sql = "SELECT " + category.getValueColumn() +
                     " FROM " + category.getTableName() +
                     " WHERE " + category.getIdColumn() + " = ? AND is_active = true";

        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    public ApiResponse<AcademicQualificationResponse> saveOrUpdate(AcademicQualificationRequest request) {
        // Check if qualification already exists for this user
        Optional<AcademicQualification> existing = repository.findByUser_UserId(request.getUserId())
                .stream()
                .filter(q -> q.getQualificationTitle().equalsIgnoreCase(request.getQualificationTitle()))
                .findFirst();

        AcademicQualification entity;
        String message;

        if (existing.isPresent()) {
            // Update existing record
            entity = existing.get();
            message = "Academic qualification updated successfully";
        } else {
            // Create new record
            entity = new AcademicQualification();
            User user=new User();
            user.setUserId(request.getUserId());
            entity.setUser(user);
            message = "Academic qualification created successfully";
        }

        // Common field mapping
        entity.setQualificationTitle(request.getQualificationTitle());
        entity.setQualificationTypeId(request.getQualificationTypeId());
        entity.setInstitutionName(request.getInstitutionName());
        entity.setCountryId(request.getCountryId());
        entity.setYearOfPassing(request.getYearOfPassing());
        entity.setCertificatePath(request.getCertificatePath());

        AcademicQualification saved = repository.save(entity);
        AcademicQualificationResponse response = mapToResponse(saved);

        return new ApiResponse<>(200, message, response);
    }

    public List<AcademicQualificationResponse> getByUserId(Long userId) {
        return repository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private AcademicQualificationResponse mapToResponse(AcademicQualification entity) {
        AcademicQualificationResponse dto = new AcademicQualificationResponse();
        dto.setAcademicId(entity.getAcademicId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setQualificationTitle(entity.getQualificationTitle());
        dto.setInstitutionName(entity.getInstitutionName());
        
        dto.setQualificationTypeId(entity.getQualificationTypeId());
        dto.setCountryId(entity.getCountryId());
        dto.setYearOfPassing(entity.getYearOfPassing());
        
        //Name
        
     // Names resolved via lookup
        dto.setQualificationType(resolveLookupValue("qualification_types", entity.getQualificationTypeId()));
        dto.setCountryName(resolveLookupValue("countries", entity.getCountryId()));
        



        dto.setCertificatePath(entity.getCertificatePath());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLastUpdated(entity.getLastUpdated());

        return dto;
    }
}