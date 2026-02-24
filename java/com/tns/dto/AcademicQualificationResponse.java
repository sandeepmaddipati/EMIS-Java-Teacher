package com.tns.dto;

import java.time.LocalDateTime;

public class AcademicQualificationResponse {

    private Long academicId;
    private Long userId;
    private String qualificationTitle;
   

    private Long qualificationTypeId;
    private String qualificationType;
    
    private String institutionName;
    
    private Long countryId;
    private String countryName;
   
    private Integer yearOfPassing;
    private String certificatePath;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
	public Long getAcademicId() {
		return academicId;
	}
	public void setAcademicId(Long academicId) {
		this.academicId = academicId;
	}
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
	public String getQualificationType() {
		return qualificationType;
	}
	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	public String getCertificatePath() {
		return certificatePath;
	}
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
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
	public Integer getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(Integer yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

    
}