package com.tns.dto;

import jakarta.validation.constraints.*;

public class TeachingQualificationRequest {

    private Long teachingQualificationId;

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotBlank(message = "Qualification name is required")
    @Size(max = 255)
    private String qualificationName;

    @NotBlank(message = "Certification type is required")
    private String certificationType;

    @NotBlank(message = "Institution name is required")
    @Size(max = 255)
    private String institutionName;

    @NotNull(message = "Country is required")
    private Long countryId;

    @NotNull @Min(1900) @Max(2100)
    private Integer startYear;

    @NotNull @Min(1900) @Max(2100)
    private Integer endYear;

    // ===== Getters & Setters =====

    public Long getTeachingQualificationId() {
        return teachingQualificationId;
    }

    public void setTeachingQualificationId(Long teachingQualificationId) {
        this.teachingQualificationId = teachingQualificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getCertificationType() {
        return certificationType;
    }

    public void setCertificationType(String certificationType) {
        this.certificationType = certificationType;
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
