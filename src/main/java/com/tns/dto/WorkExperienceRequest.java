package com.tns.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WorkExperienceRequest{
	

	    @NotNull(message = "User ID is required")
	    private Long userId;

	    @NotBlank(message = "Job title is required")
	    @Size(max = 150)
	    private String jobTitle;

	    @NotBlank(message = "Institution name is required")
	    @Size(max = 200)
	    private String institutionName;

	    @NotNull(message = "Region is required")
	    private Long regionId;

	    @NotNull(message = "District is required")
	    private Long districtId;

	    @NotNull(message = "Start Date is required")
	    private LocalDate startDate;
	    
	    private LocalDate endDate;
	  
	    private String referenceName;
	    private String referencePhone;
	    private String referenceEmail;
	    private String supportingDocumentPath;
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
		public Long getDistrictId() {
			return districtId;
		}
		public void setDistrictId(Long districtId) {
			this.districtId = districtId;
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
	    
		
	}

