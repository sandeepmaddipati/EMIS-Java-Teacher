package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tns.dto.LookupMaster;
import com.tns.dto.LookupValueResponse;
import com.tns.model.LookupCategory;
import com.tns.repository.LookupCategoryRepository;

@Service
public class LookupService {

    @Autowired
    private LookupCategoryRepository categoryRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // Get all lookup categories
    public List<LookupMaster> getLookupMaster() {
        return categoryRepo.findAll()
                .stream()
                .map(category -> {
                    LookupMaster dto = new LookupMaster();
                    dto.setCategoryId(category.getCategoryId());
                    dto.setCategoryKey(category.getCategoryKey());
                    dto.setTableName(category.getTableName());
                    return dto;
                })
                .toList();
    }


    public List<LookupValueResponse> getValues(String categoryKey) {
        LookupCategory category = categoryRepo.findByCategoryKeyAndIsActiveTrue(categoryKey)
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryKey));

        String sql = "SELECT " + category.getIdColumn() + ", " + category.getValueColumn() +
                     " FROM " + category.getTableName() +
                     " WHERE is_active = true";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new LookupValueResponse(
                rs.getLong(category.getIdColumn()),
                rs.getString(category.getValueColumn())
            )
        );
    }
    
 // Special case: subjects by type
    public List<LookupValueResponse> getSubjectsByType(Long typeId) {
    	String sql = "SELECT subject_id, subject_name FROM subjects WHERE subject_type_id = ? AND is_active = true";

    	return jdbcTemplate.query(sql, (rs, rowNum) ->
    	    new LookupValueResponse(
    	        rs.getLong("subject_id"),
    	        rs.getString("subject_name")
    	    ), typeId);


}
}
