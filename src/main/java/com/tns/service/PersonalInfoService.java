package com.tns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.ApiResponse;
import com.tns.dto.PersonalInfoRequest;
import com.tns.dto.PersonalInfoResponse;
import com.tns.model.LookupCategory;
import com.tns.model.PersonalInfo;
import com.tns.repository.LookupCategoryRepository;
import com.tns.repository.PersonalInfoRepository;

@Service
public class PersonalInfoService {

    @Autowired
    private PersonalInfoRepository repository;

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



    public ApiResponse<PersonalInfoResponse> saveOrUpdate(PersonalInfoRequest request) {
        Optional<PersonalInfo> existing = repository.findByUserId(request.getUserId());

        PersonalInfo entity;
        String message;

        if (existing.isPresent()) {
            entity = existing.get();
            message = "Personal info updated successfully";
        } else {
            entity = new PersonalInfo();
            entity.setUserId(request.getUserId());
            message = "Personal info created successfully";
        }

        // Common field mapping
        entity.setFullName(request.getFullName());
        entity.setNationalIdNumber(request.getNationalIdNumber());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setGenderId(request.getGenderId());
        entity.setNationalityId(request.getNationalityId());
        entity.setMaritalStatusId(request.getMaritalStatusId());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setEmailAddress(request.getEmailAddress());
        entity.setPermanentAddress(request.getPermanentAddress());
        entity.setPresentAddress(request.getPresentAddress());
        entity.setProfilePhotoPath(request.getProfilePhotoPath());

        PersonalInfo saved = repository.save(entity);
        PersonalInfoResponse response = mapToResponse(saved);

        return new ApiResponse<>(200, message, response);
    }

    public Optional<PersonalInfoResponse> getByUserId(Long userId) {
        return repository.findByUserId(userId)
                         .map(this::mapToResponse);
    }

    private PersonalInfoResponse mapToResponse(PersonalInfo entity) {
        PersonalInfoResponse dto = new PersonalInfoResponse();
        dto.setPersonalId(entity.getPersonalId());
        dto.setUserId(entity.getUserId());
        dto.setFullName(entity.getFullName());
        dto.setNationalIdNumber(entity.getNationalIdNumber());
        dto.setDateOfBirth(entity.getDateOfBirth());

        // IDs
        dto.setGenderId(entity.getGenderId());
        dto.setNationalityId(entity.getNationalityId());
        dto.setMaritalStatusId(entity.getMaritalStatusId());

        // ✅ Resolve names dynamically via lookup_categories
        dto.setGenderName(resolveLookupValue("genders", entity.getGenderId()));
        dto.setNationalityName(resolveLookupValue("nationalities", entity.getNationalityId()));
        dto.setMaritalStatusName(resolveLookupValue("marital_statuses", entity.getMaritalStatusId()));

        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setPermanentAddress(entity.getPermanentAddress());
        dto.setPresentAddress(entity.getPresentAddress());
        dto.setProfilePhotoPath(entity.getProfilePhotoPath());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setLastUpdated(entity.getLastUpdated());

        return dto;
    }
}