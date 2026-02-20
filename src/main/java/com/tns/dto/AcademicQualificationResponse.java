package com.tns.dto;

public class AcademicQualificationResponse {

	private Long academicQualificationId;
    private String qualificationLevel;
    private String institutionName;
    private String fieldOfStudy;
    private String country;
    private Integer startYear;
    private Integer endYear;
	public Long getAcademicQualificationId() {
		return academicQualificationId;
	}
	public void setAcademicQualificationId(Long academicQualificationId) {
		this.academicQualificationId = academicQualificationId;
	}
	public String getQualificationLevel() {
		return qualificationLevel;
	}
	public void setQualificationLevel(String qualificationLevel) {
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
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
	
	}
    
    
