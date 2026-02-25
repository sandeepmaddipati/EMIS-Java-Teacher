package com.tns.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.ApiResponse;
import com.tns.dto.DocumentRequest;
import com.tns.dto.DocumentResponse;
import com.tns.model.Document;
import com.tns.model.LookupCategory;
import com.tns.model.User;
import com.tns.repository.DocumentRepository;
import com.tns.repository.LookupCategoryRepository;

@Service

public class DocumentService{
	
	@Autowired
	private DocumentRepository repository;
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
	
	public ApiResponse<DocumentResponse> saveOrUpdate(DocumentRequest request){
		Optional<Document> existing = repository.findByuser_UserId(request.getUserId())
		.stream()
		.filter(d -> d.getFileName().equalsIgnoreCase(request.getFileName()))
        .findFirst();
          Document entity;
          String message;
          
          if(existing.isPresent()) {
        	  entity=existing.get();
        	  message="Documents Updated Successfully";
          }else {
        	  
        	  entity=new Document();
        	  User user=new User();
        	  user.setUserId(request.getUserId());
               message="Documents Saved Successfully";
          }
          
          entity.setDocumentTypeId(request.getDocumentTypeId());
          entity.setFileName(request.getFileName());
          entity.setFilePath(request.getFilePath());

          Document saved = repository.save(entity);
          DocumentResponse response = mapToResponse(saved);

          return new ApiResponse<>(200, message, response);

	}
	
	public List<DocumentResponse> getByUserId ( Long userId){
		return repository.findByuser_UserId(userId)
				.stream()
				.map(this::mapToResponse)
				.toList();
	}
	 private DocumentResponse mapToResponse(Document entity) {
	        DocumentResponse dto = new DocumentResponse();
	        dto.setDocumentId(entity.getDocumentId());
	        dto.setUserId(entity.getUser().getUserId());
	        dto.setDocumentTypeId(entity.getDocumentTypeId());
	        dto.setDocumentType(resolveLookupValue("document_types",entity.getDocumentTypeId()));
	        dto.setFileName(entity.getFileName());
	        dto.setFilePath(entity.getFilePath());
	        dto.setUploadedAt(entity.getUploadedAt());
	       
	        return dto;
	    }

	
}