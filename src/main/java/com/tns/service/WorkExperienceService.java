package com.tns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.ApiResponse;
import com.tns.dto.WorkExperienceRequest;
import com.tns.dto.WorkExperienceResponse;
import com.tns.model.LookupCategory;
import com.tns.model.User;
import com.tns.model.WorkExperience;
import com.tns.repository.LookupCategoryRepository;
import com.tns.repository.WorkExperienceRepository;

@Service
public class WorkExperienceService{
	
	@Autowired
	private WorkExperienceRepository repository;
	
	@Autowired
	private LookupCategoryRepository categoryRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private String resolveLookupValue(String categoryKey,Long id) {
        if (id == null) return null;
      LookupCategory category=categoryRepo.findByCategoryKeyAndIsActiveTrue(categoryKey)
    		  .orElseThrow(()->new RuntimeException("Category Not Found:" + categoryKey));
      
      String sql = "SELECT " + category.getValueColumn() +
              " FROM " + category.getTableName() +
              " WHERE " + category.getIdColumn() + " = ? AND is_active = true";

 return jdbcTemplate.queryForObject(sql, String.class, id);
}
    
	
	public ApiResponse<WorkExperienceResponse> saveOrUpdate(WorkExperienceRequest request){
		
		Optional<WorkExperience> existing= repository.findByUser_UserId(request.getUserId())
				.stream()
				.filter(w -> w.getJobTitle().equalsIgnoreCase(request.getJobTitle())
                        && w.getInstitutionName().equalsIgnoreCase(request.getInstitutionName()))
              .findFirst();
		WorkExperience entity;
		String message;
		
		if(existing.isPresent()) {
			entity=existing.get();
			message="Work experinece Updated Successfully";
		}else {
			
			entity=new WorkExperience();
			User user=new User();
			user.setUserId(request.getUserId());
			message="Work Experinece Saved Successfully";
		}
		entity.setJobTitle(request.getJobTitle());
        entity.setInstitutionName(request.getInstitutionName());
        entity.setRegionId(request.getRegionId());
        entity.setDistrictId(request.getDistrictId());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        // ✅ Auto-set currentlyWorking based on endDate
        if (request.getEndDate() == null) {
            entity.setCurrentlyWorking(true);
        } else {
            entity.setCurrentlyWorking(false);
        }

       
        entity.setReferenceName(request.getReferenceName());
        entity.setReferencePhone(request.getReferencePhone());
        entity.setReferenceEmail(request.getReferenceEmail());
        entity.setSupportingDocumentPath(request.getSupportingDocumentPath());
      
        WorkExperience saved=repository.save(entity);
        
        WorkExperienceResponse response = mapToResponse(saved);
        return new ApiResponse <> (200,message,response);

	
	}
	
	 public List<WorkExperienceResponse> getByUserId(Long userId) {
	        return repository.findByUser_UserId(userId)
	                .stream()
	                .map(this::mapToResponse)
	                .toList();
	    }
	 
	 	private WorkExperienceResponse mapToResponse (WorkExperience entity) {
	 		WorkExperienceResponse dto=new WorkExperienceResponse();
	 		dto.setWorkId(entity.getWorkId());
	 		 dto.setUserId(entity.getUser().getUserId());
	         dto.setJobTitle(entity.getJobTitle());
	         dto.setInstitutionName(entity.getInstitutionName());
	         dto.setRegionId(entity.getRegionId());
	         dto.setDistrictId(entity.getDistrictId());
	         dto.setStartDate(entity.getStartDate());
	         dto.setEndDate(entity.getEndDate());
	       
	         
	         //Name
	         
	         dto.setRegionName(resolveLookupValue("regions",entity.getRegionId()));
	         dto.setDistrictName(resolveLookupValue("districts",entity.getDistrictId()));
	         
	         dto.setCurrentlyWorking(entity.getCurrentlyWorking());
	         dto.setReferenceName(entity.getReferenceName());
	         dto.setReferencePhone(entity.getReferencePhone());
	         dto.setReferenceEmail(entity.getReferenceEmail());
	         dto.setSupportingDocumentPath(entity.getSupportingDocumentPath());
	         dto.setCreatedAt(entity.getCreatedAt());
	         dto.setLastUpdated(entity.getLastUpdated());
	         return dto;

	 		
	 	}

	
}