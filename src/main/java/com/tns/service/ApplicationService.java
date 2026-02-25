package com.tns.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.ApiResponse;
import com.tns.dto.ApplicationRequest;
import com.tns.dto.ApplicationResponse;
import com.tns.model.Application;
import com.tns.model.LookupCategory;
import com.tns.model.User;
import com.tns.repository.AcademicQualificationRepository;
import com.tns.repository.ApplicationRepository;
import com.tns.repository.DocumentRepository;
import com.tns.repository.LookupCategoryRepository;
import com.tns.repository.PersonalInfoRepository;
import com.tns.repository.TeachingQualificationRepository;
import com.tns.repository.WorkExperienceRepository;

@Service
public class ApplicationService {

    @Autowired private ApplicationRepository repository;
    @Autowired private PersonalInfoRepository personalRepo;
    @Autowired private AcademicQualificationRepository academicRepo;
    @Autowired private TeachingQualificationRepository teachingRepo;
    @Autowired private WorkExperienceRepository workRepo;
    @Autowired private DocumentRepository documentRepo;
    
    @Autowired
	private LookupCategoryRepository categoryRepo;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	private String resolveLookupValue(String categoryKey,Long id) {
        if (id == null) return null;
        LookupCategory category=categoryRepo.findByCategoryKeyAndIsActiveTrue(categoryKey)
        		.orElseThrow(()-> new RuntimeException("Category Not Found:"+categoryKey));

        	      String sql = "SELECT " + category.getValueColumn() +
        	              " FROM " + category.getTableName() +
        	              " WHERE " + category.getIdColumn() + " = ? AND is_active = true";

        	 return jdbcTemplate.queryForObject(sql, String.class, id);
    }
	
    public ApiResponse<ApplicationResponse> submitApplication(ApplicationRequest request) {
        boolean personalInfoExists = personalRepo.findByUser_UserId(request.getUserId()).isPresent();
        boolean academicExists = !academicRepo.findByUser_UserId(request.getUserId()).isEmpty();
        boolean teachingExists = !teachingRepo.findByUser_UserId(request.getUserId()).isEmpty();
        boolean workExists = !workRepo.findByUser_UserId(request.getUserId()).isEmpty();
        boolean documentsExist = !documentRepo.findByuser_UserId(request.getUserId()).isEmpty();

        Application entity = repository.findByApplicationCode(request.getApplicationCode())
                .orElse(new Application());

     // ✅ Map User relationship
        User user = new User();
        user.setUserId(request.getUserId());
        entity.setUser(user);

        entity.setApplicationCode(request.getApplicationCode());
        entity.setRegionId(request.getRegionId());
        entity.setRemarks(request.getRemarks());
        entity.setSubmittedOn(LocalDate.now());
        entity.setLastUpdated(LocalDateTime.now());

        String message;
        if (personalInfoExists && academicExists && teachingExists && workExists && documentsExist) {
            entity.setApplicationStatusId(2L); // Submitted
            message = "Application submitted successfully";
        } else {
            entity.setApplicationStatusId(1L); // Draft
            message = "Application saved as draft";
        }
     // enforce consistency: only one of approved/rejected
        if (entity.getApprovedById() != null && entity.getRejectedById() != null) {
            throw new RuntimeException("Application cannot be both approved and rejected.");
        }


        Application saved = repository.save(entity);
        ApplicationResponse response = mapToResponse(saved);

        return new ApiResponse<>(200, message, response);
    }

    public List<ApplicationResponse> getSubmittedApplications(Long userId) {
        return repository.findByUser_UserId(userId)
                .stream()
                .filter(app -> app.getApplicationStatusId() != 1L) // exclude drafts
                .map(this::mapToResponse)
                .toList();
    }

    public List<ApplicationResponse> getAllApplications(Long userId) {
        return repository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ApplicationResponse mapToResponse(Application entity) {
        ApplicationResponse dto = new ApplicationResponse();
        dto.setApplicationId(entity.getApplicationId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setApplicationCode(entity.getApplicationCode());
        dto.setRegionId(entity.getRegionId());
        dto.setApplicationStatusId(entity.getApplicationStatusId());
        
        dto.setRegionName(resolveLookupValue("regions",entity.getRegionId()));
        dto.setApplicationStatus(resolveLookupValue("application_statuses",entity.getApplicationStatusId()));
        dto.setSubmittedOn(entity.getSubmittedOn());
        dto.setLastUpdated(entity.getLastUpdated());
        dto.setRemarks(entity.getRemarks());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setApprovedById(entity.getApprovedById());
        dto.setRejectedById(entity.getRejectedById());


        return dto;
    }
}