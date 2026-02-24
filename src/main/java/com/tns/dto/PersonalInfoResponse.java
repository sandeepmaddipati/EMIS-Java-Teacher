package com.tns.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonalInfoResponse {

	  private Long personalId;
	    private Long userId;
	    private String fullName;
	    private String nationalIdNumber;
	    private LocalDate dateOfBirth;

	    private Long genderId;
	    private String genderName;          // ✅ Added

	    private Long nationalityId;
	    private String nationalityName;     // ✅ Added

	    private Long maritalStatusId;
	    private String maritalStatusName;   // ✅ Added

	    private String phoneNumber;
	    private String emailAddress;
	    private String permanentAddress;
	    private String presentAddress;
	    private String profilePhotoPath;
	    private LocalDateTime createdAt;
	    private LocalDateTime lastUpdated;
		public Long getPersonalId() {
			return personalId;
		}
		public void setPersonalId(Long personalId) {
			this.personalId = personalId;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
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
		public String getGenderName() {
			return genderName;
		}
		public void setGenderName(String genderName) {
			this.genderName = genderName;
		}
		public Long getNationalityId() {
			return nationalityId;
		}
		public void setNationalityId(Long nationalityId) {
			this.nationalityId = nationalityId;
		}
		public String getNationalityName() {
			return nationalityName;
		}
		public void setNationalityName(String nationalityName) {
			this.nationalityName = nationalityName;
		}
		public Long getMaritalStatusId() {
			return maritalStatusId;
		}
		public void setMaritalStatusId(Long maritalStatusId) {
			this.maritalStatusId = maritalStatusId;
		}
		public String getMaritalStatusName() {
			return maritalStatusName;
		}
		public void setMaritalStatusName(String maritalStatusName) {
			this.maritalStatusName = maritalStatusName;
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