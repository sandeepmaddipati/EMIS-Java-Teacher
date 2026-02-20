package com.tns.dto;

public class TeachingQualificationResponse {

    private Long TeachingQualificationId;
    private String qualificationName;
    private String certificationTypeId;
    private String institutionName;
    private String countryName;
    private Integer startYear;
    private Integer endYear;
	public Long getTeachingQualificationId() {
		return TeachingQualificationId;
	}
	public void setTeachingQualificationId(Long teachingQualificationId) {
		TeachingQualificationId = teachingQualificationId;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	public String getCertificationTypeId() {
		return certificationTypeId;
	}
	public void setCertificationTypeId(String certificationTypeId) {
		this.certificationTypeId = certificationTypeId;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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