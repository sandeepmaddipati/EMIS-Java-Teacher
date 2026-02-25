package com.tns.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "academic_qualifications")
public class AcademicQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="academic_id")
    private Long academicId;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="qualification_title",nullable = false, length = 255)
    private String qualificationTitle;

    @Column(name="qualification_type_id",nullable = false)
    private Long qualificationTypeId;   // from lookup_values

    @Column(name="institution_name",nullable = false, length = 255)
    private String institutionName;

    @Column(name="country_id",nullable = false)
    private Long countryId;             // from lookup_values

    @Column(name="year_of_passing")
    private Integer yearOfPassing;       

    @Column(name="certificate_path",length = 500)
    private String certificatePath;

    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();


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