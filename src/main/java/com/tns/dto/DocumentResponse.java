package com.tns.dto;

import java.time.LocalDateTime;

public class DocumentResponse {

    private Long documentId;
    private Long userId;
    private Long documentTypeId;
    private String documentType;
    private String fileName;
    private String filePath;
    private LocalDateTime uploadedAt;
   private LocalDateTime lastUpdated;
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getDocumentTypeId() {
		return documentTypeId;
	}
	public void setDocumentTypeId(Long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}
	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
    
    
    
    
	
}