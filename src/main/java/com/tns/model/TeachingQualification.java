package com.tns.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teaching_qualifications")
public class TeachingQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teaching_id")
    private Long teachingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name="certification_name",nullable = false, length = 255)
    private String certificationName;

    @Column(name="certification_type_id",nullable = false)
    private Long certificationTypeId;   // from lookup_values

    @Column(name="institution_name",nullable = false, length = 255)
    private String institutionName;

    @Column(name="country_id",nullable = false)
    private Long countryId;             // from lookup_values

    @Column(name="year_of_passing",nullable = false)
    private Integer yearOfPassing;               

    @Column(name="certificate_path",length = 500)
    private String certificatePath;

    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();

	public Long getTeachingId() {
		return teachingId;
	}

	public void setTeachingId(Long teachingId) {
		this.teachingId = teachingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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