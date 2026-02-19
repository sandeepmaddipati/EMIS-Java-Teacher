package com.tns.dto;

import jakarta.validation.constraints.*;

public class WorkExperienceRequest {

    private Long workId;

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotBlank(message = "Job title is required")
    @Size(max = 150)
    private String jobTitle;

    @NotBlank(message = "Institution name is required")
    @Size(max = 200)
    private String institutionName;

    @NotNull(message = "Country is required")
    private Long countryId;

    @NotNull(message = "State is required")
    private Long stateId;

    @NotNull(message = "District is required")
    private Long districtId;

    @NotNull @Min(1) @Max(12)
    private Integer startMonth;

    @NotNull @Min(1900) @Max(2100)
    private Integer startYear;

    @Min(1) @Max(12)
    private Integer endMonth;

    @Min(1900) @Max(2100)
    private Integer endYear;

    @Size(max = 150)
    private String referenceName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String referencePhone;

    @Email(message = "Invalid email")
    private String referenceEmail;

    @Size(max = 255)
    private String supportingDocument;

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

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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
