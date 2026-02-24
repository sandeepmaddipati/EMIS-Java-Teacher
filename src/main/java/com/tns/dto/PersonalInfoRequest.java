package com.tns.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonalInfoRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Full name is required")
    @Size(max = 150, message = "Full name must be less than 150 characters")
    private String fullName;

    @NotBlank(message = "National ID number is required")
    private String nationalIdNumber;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    private Long genderId;
    private Long nationalityId;
    private Long maritalStatusId;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be 10-15 digits")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String emailAddress;

    @NotBlank(message = "Permanent address is required")
    private String permanentAddress;

    private String presentAddress;
    private String profilePhotoPath;
    
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
	

    
    
   }