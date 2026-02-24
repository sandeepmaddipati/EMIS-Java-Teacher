package com.tns.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="work_id")
    private Long workId;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="job_title",nullable = false, length = 150)
    private String jobTitle;

    @Column(name="institution_name",nullable = false, length = 200)
    private String institutionName;

    @Column(name="region_id",nullable = false)
    private Long regionId;      // from lookup_values

    @Column(name="district_id",nullable = false)
    private Long districtId;    // from lookup_values

   
    @Column(name="start_date",nullable = false)
    private LocalDate startDate;   

    @Column(name="end_date")
    private LocalDate endDate;   



    @Column(name="currently_working",nullable = false)
    private Boolean currentlyWorking = false;

    @Column(name="reference_name",length = 150)
    private String referenceName;
    @Column(length = 10)
    private String referencePhone;

 
    @Column(name="reference_email",length = 150)
    private String referenceEmail;

    @Column(name="supporting_document_path",length = 500)
    private String supportingDocumentPath;

    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();

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