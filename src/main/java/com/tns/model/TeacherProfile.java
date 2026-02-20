package com.tns.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_profiles")
public class TeacherProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String fullName;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private MasterLookup gender;

    @ManyToOne
    @JoinColumn(name = "marital_status_id")
    private MasterLookup maritalStatus;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private MasterLookup nationality;

    private String nationalIdNumber;
    private String address;
    private String profilePhotoPath;
    private LocalDateTime createdAt = LocalDateTime.now();
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public MasterLookup getGender() {
		return gender;
	}
	public void setGender(MasterLookup gender) {
		this.gender = gender;
	}
	public MasterLookup getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MasterLookup maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public MasterLookup getNationality() {
		return nationality;
	}
	public void setNationality(MasterLookup nationality) {
		this.nationality = nationality;
	}
	public String getNationalIdNumber() {
		return nationalIdNumber;
	}
	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
    
}