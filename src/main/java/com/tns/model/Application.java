package com.tns.model;

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
@Table(name="applications")
public class Application {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long applicationId;

    @OneToOne
    @JoinColumn(name="teacher_id", nullable=false, unique=true)
    private TeacherProfile teacher;

    @ManyToOne
    @JoinColumn(name="application_status_id", nullable=false)
    private MasterLookup status;

    private LocalDateTime submittedAt;
    private LocalDateTime createdAt = LocalDateTime.now();
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public TeacherProfile getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherProfile teacher) {
		this.teacher = teacher;
	}
	public MasterLookup getStatus() {
		return status;
	}
	public void setStatus(MasterLookup status) {
		this.status = status;
	}
	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}
	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
 
    
    
}