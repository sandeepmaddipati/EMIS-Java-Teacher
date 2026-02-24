package com.tns.dto;

import java.time.LocalDateTime;

public class TeachingQualificationResponse {

    private Long teachingId;
    private Long userId;
   
    private Long certificationTypeId;
    private String certificationType;
    private String institutionName;
    private Long countryId;
    private String countryName;
   
    private Integer yearOfPassing;
    private String certificatePath;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
	public Long getTeachingId() {
		return teachingId;
	}
	public void setTeachingId(Long teachingId) {
		this.teachingId = teachingId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCertificationTypeId() {
		return certificationTypeId;
	}
	public void setCertificationTypeId(Long certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
	}
	public String getCertificationType() {
		return certificationType;
	}
	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
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