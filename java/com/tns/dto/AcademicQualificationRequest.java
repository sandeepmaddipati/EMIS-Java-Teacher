package com.tns.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AcademicQualificationRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Qualification title is required")
    @Size(max = 255, message = "Qualification title must be less than 255 characters")
    private String qualificationTitle;

    @NotNull(message = "Qualification type is required")
    private Long qualificationTypeId;

    @NotBlank(message = "Institution name is required")
    @Size(max = 255, message = "Institution name must be less than 255 characters")
    private String institutionName;

    @NotNull(message = "Country is required")
    private Long countryId;

    private Integer yearOfPassing;

    private String certificatePath;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getQualificationTitle() {
		return qualificationTitle;
	}

	public void setQualificationTitle(String qualificationTitle) {
		this.qualificationTitle = qualificationTitle;
	}

	public Long getQualificationTypeId() {
		return qualificationTypeId;
	}

	public void setQualificationTypeId(Long qualificationTypeId) {
		this.qualificationTypeId = qualificationTypeId;
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

	public Integer getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(Integer yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}

	
    
    
}