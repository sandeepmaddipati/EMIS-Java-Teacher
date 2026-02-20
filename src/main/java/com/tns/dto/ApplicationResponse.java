package com.tns.dto;

import java.time.LocalDateTime;

public class ApplicationResponse {
	 private Long applicationId;
	    private String teacherName;
	    private String status;
	    private LocalDateTime submittedAt;
		public Long getApplicationId() {
			return applicationId;
		}
		public void setApplicationId(Long applicationId) {
			this.applicationId = applicationId;
		}
		public String getTeacherName() {
			return teacherName;
		}
		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public LocalDateTime getSubmittedAt() {
			return submittedAt;
		}
		public void setSubmittedAt(LocalDateTime submittedAt) {
			this.submittedAt = submittedAt;
		}
	    
	    
}
