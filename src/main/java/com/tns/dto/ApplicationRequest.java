package com.tns.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ApplicationRequest {
	
	 private Long applicationId;

    @NotNull 
    private Long userId;

    

    @NotNull 
    private Long regionId;

    private Long applicationStatusId;
    private LocalDate submittedOn;
    private String remarks;

    // New fields for approval/rejection
    private Long approvedById;
    private Long rejectedById;

    // getters and setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    public Long getRegionId() {
        return regionId;
    }
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getApplicationStatusId() {
        return applicationStatusId;
    }
    public void setApplicationStatusId(Long applicationStatusId) {
        this.applicationStatusId = applicationStatusId;
    }

    public LocalDate getSubmittedOn() {
        return submittedOn;
    }
    public void setSubmittedOn(LocalDate submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getApprovedById() {
        return approvedById;
    }
    public void setApprovedById(Long approvedById) {
        this.approvedById = approvedById;
    }

    public Long getRejectedById() {
        return rejectedById;
    }
    public void setRejectedById(Long rejectedById) {
        this.rejectedById = rejectedById;
    }
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
}