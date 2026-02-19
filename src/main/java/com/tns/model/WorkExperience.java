package com.tns.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Long workId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfile teacher;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "institution_name")
    private String institutionName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "start_month")
    private Integer startMonth;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_month")
    private Integer endMonth;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "reference_name")
    private String referenceName;

    @Column(name = "reference_phone")
    private String referencePhone;

    @Column(name = "reference_email")
    private String referenceEmail;

    @Column(name = "supporting_document")
    private String supportingDocument;

    // ===== GETTERS & SETTERS =====

    public Long getWorkId() { return workId; }
    public void setWorkId(Long workId) { this.workId = workId; }

    public TeacherProfile getTeacher() { return teacher; }
    public void setTeacher(TeacherProfile teacher) { this.teacher = teacher; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getInstitutionName() { return institutionName; }
    public void setInstitutionName(String institutionName) { this.institutionName = institutionName; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; }

    public Integer getStartMonth() { return startMonth; }
    public void setStartMonth(Integer startMonth) { this.startMonth = startMonth; }

    public Integer getStartYear() { return startYear; }
    public void setStartYear(Integer startYear) { this.startYear = startYear; }

    public Integer getEndMonth() { return endMonth; }
    public void setEndMonth(Integer endMonth) { this.endMonth = endMonth; }

    public Integer getEndYear() { return endYear; }
    public void setEndYear(Integer endYear) { this.endYear = endYear; }

    public String getReferenceName() { return referenceName; }
    public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

    public String getReferencePhone() { return referencePhone; }
    public void setReferencePhone(String referencePhone) { this.referencePhone = referencePhone; }

    public String getReferenceEmail() { return referenceEmail; }
    public void setReferenceEmail(String referenceEmail) { this.referenceEmail = referenceEmail; }

    public String getSupportingDocument() { return supportingDocument; }
    public void setSupportingDocument(String supportingDocument) { this.supportingDocument = supportingDocument; }
}
