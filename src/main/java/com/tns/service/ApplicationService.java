package com.tns.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.tns.repository.UserRepository;
import com.tns.repository.WorkExperienceRepository;

@Service
@Transactional
public class ApplicationService {

    @Autowired private ApplicationRepository repository;
    @Autowired private PersonalInfoRepository personalRepo;
    @Autowired private AcademicQualificationRepository academicRepo;
    @Autowired private TeachingQualificationRepository teachingRepo;
    @Autowired private WorkExperienceRepository workRepo;
    @Autowired private DocumentRepository documentRepo;

    @Autowired private UserRepository userRepository;
    
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

    // =========================================
    // SUBMIT / SAVE APPLICATION
    // =========================================
    public ApiResponse<ApplicationResponse> submitApplication(ApplicationRequest request) {

        Long userId = request.getUserId();

        boolean personalInfoExists = personalRepo.findByUser_UserId(userId).isPresent();
        boolean academicExists = !academicRepo.findByUser_UserId(userId).isEmpty();
        boolean teachingExists = !teachingRepo.findByUser_UserId(userId).isEmpty();
        boolean workExists = !workRepo.findByUser_UserId(userId).isEmpty();
        boolean documentsExist = !documentRepo.findByuser_UserId(userId).isEmpty();

        boolean allSectionsCompleted =
                personalInfoExists &&
                academicExists &&
                teachingExists &&
                workExists &&
                documentsExist;

        Application entity;

        // ================= FETCH OR CREATE =================
        if (request.getApplicationId() != null) {

            entity = repository.findById(request.getApplicationId())
                    .orElseThrow(() -> new RuntimeException("Application not found"));

            // Prevent editing Approved (3) or Rejected (4)
            if (entity.getApplicationStatusId() != null &&
               (entity.getApplicationStatusId() == 3L ||
                entity.getApplicationStatusId() == 4L)) {

                throw new RuntimeException("Approved/Rejected applications cannot be modified.");
            }

        } else {

            entity = new Application();
            entity.setApplicationCode(generateApplicationCode());
            entity.setCreatedAt(LocalDateTime.now());

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            entity.setUser(user);
        }

        // ================= MAP FIELDS =================
        entity.setRegionId(request.getRegionId());
        entity.setRemarks(request.getRemarks());
        entity.setLastUpdated(LocalDateTime.now());

        String message;

        // ================= STATUS LOGIC =================
        if (allSectionsCompleted) {

            if (entity.getApplicationStatusId() == null ||
                entity.getApplicationStatusId() == 1L) {

                entity.setApplicationStatusId(2L); // Submitted
                entity.setSubmittedOn(LocalDate.now());
            }

            message = "Application submitted successfully";

        } else {

            entity.setApplicationStatusId(1L); // Draft
            entity.setSubmittedOn(null);
            message = "Application saved as draft";
        }

        Application saved = repository.save(entity);

        return new ApiResponse<>(200, message, mapToResponse(saved));
    }

    // =========================================
    // GET SUBMITTED APPLICATIONS
    // =========================================
    public List<ApplicationResponse> getSubmittedApplications(Long userId) {

        return repository.findByUser_UserId(userId)
                .stream()
                .filter(app -> app.getApplicationStatusId() == 2L)
                .map(this::mapToResponse)
                .toList();
    }

    // =========================================
    // GET ALL APPLICATIONS
    // =========================================
    public List<ApplicationResponse> getAllApplications(Long userId) {

        return repository.findByUser_UserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // =========================================
    // MAP ENTITY → DTO
    // =========================================
    private ApplicationResponse mapToResponse(Application entity) {

        ApplicationResponse dto = new ApplicationResponse();

        dto.setApplicationId(entity.getApplicationId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setApplicationCode(entity.getApplicationCode());
        dto.setRegionId(entity.getRegionId());
        dto.setRegionName(resolveLookupValue("regions",entity.getRegionId()));
        dto.setApplicationStatusId(entity.getApplicationStatusId());
        dto.setApplicationStatus(resolveLookupValue("application_statuses",entity.getApplicationStatusId()));
        dto.setSubmittedOn(entity.getSubmittedOn());
        dto.setLastUpdated(entity.getLastUpdated());
        dto.setRemarks(entity.getRemarks());
        dto.setCreatedAt(entity.getCreatedAt());

        if (entity.getApprovedBy() != null) {
            dto.setApprovedById(entity.getApprovedBy().getUserId());
        }

        if (entity.getRejectedBy() != null) {
            dto.setRejectedById(entity.getRejectedBy().getUserId());
        }

        return dto;
    }

    // =========================================
    // GENERATE CODE
    // =========================================
    private String generateApplicationCode() {
        return "APP-" + System.currentTimeMillis();
    }
}