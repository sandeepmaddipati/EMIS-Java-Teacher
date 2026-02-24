package com.tns.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApplicationResponse {
    private Long applicationId;
    private Long userId;
    private String applicationCode;
    private Long regionId;
    private String regionName;
    private Long applicationStatusId;
    private String applicationStatus;
    private LocalDate submittedOn;
    private String remarks;
    
    private Long approvedById;
    private Long rejectedById;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Long getApplicationStatusId() {
		return applicationStatusId;
	}
	public void setApplicationStatusId(Long applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
    
    
	
}