package com.tns.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WorkExperienceResponse {

    private Long workId;
    private Long userId;
    private String jobTitle;
    private String institutionName;
    private Long regionId;
    private String regionName;
    private Long districtId;
    private String districtName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean currentlyWorking;
    private String referenceName;
    private String referencePhone;
    private String referenceEmail;
    private String supportingDocumentPath;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
	public Long getWorkId() {
		return workId;
	}
	public void setWorkId(Long workId) {
		this.workId = workId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Boolean getCurrentlyWorking() {
		return currentlyWorking;
	}
	public void setCurrentlyWorking(Boolean currentlyWorking) {
		this.currentlyWorking = currentlyWorking;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getReferencePhone() {
		return referencePhone;
	}
	public void setReferencePhone(String referencePhone) {
		this.referencePhone = referencePhone;
	}
	public String getReferenceEmail() {
		return referenceEmail;
	}
	public void setReferenceEmail(String referenceEmail) {
		this.referenceEmail = referenceEmail;
	}
	public String getSupportingDocumentPath() {
		return supportingDocumentPath;
	}
	public void setSupportingDocumentPath(String supportingDocumentPath) {
		this.supportingDocumentPath = supportingDocumentPath;
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