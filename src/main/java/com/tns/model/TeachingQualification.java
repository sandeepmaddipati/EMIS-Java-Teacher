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
@Table(name = "teaching_qualifications")
public class TeachingQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teachingQualificationId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfile teacher;

    private String qualificationName;

    @ManyToOne
    @JoinColumn(name = "certification_type_id")
    private MasterLookup certificationType;

    private String institutionName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private Integer startYear;
    private Integer endYear;

    private LocalDateTime createdAt = LocalDateTime.now();

	public Long getTeachingQualificationId() {
		return teachingQualificationId;
	}

	public void setTeachingQualificationId(Long teachingQualificationId) {
		this.teachingQualificationId = teachingQualificationId;
	}

	public TeacherProfile getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherProfile teacher) {
		this.teacher = teacher;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public MasterLookup getCertificationType() {
		return certificationType;
	}

	public void setCertificationType(MasterLookup certificationType) {
		this.certificationType = certificationType;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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