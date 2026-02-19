package com.tns.dto;

import jakarta.validation.constraints.*;

public class AcademicQualificationRequest {

    private Long academicQualificationId; // null for add

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotBlank(message = "Qualification level is required")
    private String qualificationLevel;

    @NotBlank
   
    private String institutionName;

    @NotBlank

    private String fieldOfStudy;

    @NotNull
    private Long countryId;

    @NotNull
    
    private Integer startYear;

    @NotNull
    private Integer endYear;

 

    public Long getAcademicQualificationId() {
        return academicQualificationId;
    }

    public void setAcademicQualificationId(Long academicQualificationId) {
        this.academicQualificationId = academicQualificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
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
