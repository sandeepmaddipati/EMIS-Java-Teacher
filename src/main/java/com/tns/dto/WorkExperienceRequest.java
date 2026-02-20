package com.tns.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class WorkExperienceRequest {
    private Long workId;
    private Long teacherId;

    @NotBlank private String jobTitle;
    @NotBlank private String institutionName;
    @NotBlank private String countryName;
    @NotBlank private String stateName;
    @NotBlank private String districtName;

    @NotNull private Integer startMonth;
    @NotNull private Integer startYear;
    private Integer endMonth;
    private Integer endYear;

    private String referenceName;     // optional
    private String referencePhone;    // optional
    private String referenceEmail;    // optional
    private String supportingDocument;// optional
	public Long getWorkId() {
		return workId;
	}
	public void setWorkId(Long workId) {
		this.workId = workId;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Integer getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	public Integer getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(Integer endMonth) {
		this.endMonth = endMonth;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
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
	public String getSupportingDocument() {
		return supportingDocument;
	}
	public void setSupportingDocument(String supportingDocument) {
		this.supportingDocument = supportingDocument;
	}

    
}