package com.tns.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TeachingQualificationRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Certification name is required")
    @Size(max = 255, message = "Certification name must be less than 255 characters")
    private String certificationName;

    @NotNull(message = "Certification type is required")
    private Long certificationTypeId;

    @NotBlank(message = "Institution name is required")
    @Size(max = 255, message = "Institution name must be less than 255 characters")
    private String institutionName;

    @NotNull(message = "Country is required")
    private Long countryId;

    @NotNull(message = "Year is required")
    private Integer yearOfPassing;

    private String certificatePath;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public Long getCertificationTypeId() {
		return certificationTypeId;
	}

	public void setCertificationTypeId(Long certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
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