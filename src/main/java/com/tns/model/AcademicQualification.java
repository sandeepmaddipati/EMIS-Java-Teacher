package com.tns.model;

import java.time.LocalDateTime;
import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "academic_qualifications")
public class AcademicQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academicQualificationId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfile teacher;

    @ManyToOne
    @JoinColumn(name = "qualification_level_id")
    private MasterLookup qualificationLevel;

    private String institutionName;
    private String fieldOfStudy;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private Integer startYear;
    private Integer endYear;
    private LocalDateTime createdAt = LocalDateTime.now();
	public Long getAcademicQualificationId() {
		return academicQualificationId;
	}
	public void setAcademicQualificationId(Long academicQualificationId) {
		this.academicQualificationId = academicQualificationId;
	}
	public TeacherProfile getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherProfile teacher) {
		this.teacher = teacher;
	}
	public MasterLookup getQualificationLevel() {
		return qualificationLevel;
	}
	public void setQualificationLevel(MasterLookup qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    
    
}
