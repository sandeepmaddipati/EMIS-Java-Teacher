package com.tns.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal_info")
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="personal_info")

    private Long personalId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;



    @Column(name="full_name",nullable = false, length = 150)
    private String fullName;

    @Column(name="national_id_number",nullable = false, length = 100)
    private String nationalIdNumber;

    @Column(name="date_of_birth",nullable = false)
    private LocalDate dateOfBirth;
    @Column(name="gender_id")
    private Long genderId;
    @Column(name="nationality_id")
    private Long nationalityId;
    @Column(name="marital_status_id")
    private Long maritalStatusId;

    @Column(name="phone_number",length = 20)
    private String phoneNumber;

    @Column(name="email_address",length = 150)
    private String emailAddress;

    @Column(name="permanent_address",nullable = false, columnDefinition = "TEXT")
    private String permanentAddress;

    @Column(name="present_address",columnDefinition = "TEXT")
    private String presentAddress;

    @Column(name="profile_photo_path",length = 500)
    private String profilePhotoPath;

    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name="last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();
    // Getters and Setters
    
    
	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Long nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getProfilePhotoPath() {
		return profilePhotoPath;
	}

	public void setProfilePhotoPath(String profilePhotoPath) {
		this.profilePhotoPath = profilePhotoPath;
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