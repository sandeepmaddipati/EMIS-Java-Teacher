package com.tns.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "academic_qualifications")
public class AcademicQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academic_qualification_id")
    private Long academicQualificationId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherProfile teacher;

    @ManyToOne
    @JoinColumn(name = "qualification_level_id")
    private MasterLookup qualificationLevel;

    @Column(name = "institution_name", nullable = false)
    private String institutionName;

    @Column(name = "field_of_study", nullable = false)
    private String fieldOfStudy;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "created_at")
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
