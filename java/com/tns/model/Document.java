package com.tns.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="document_id")
    private Long documentId;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="document_type_id",nullable = false)
    private Long documentTypeId;   // from lookup_values

    @Column(name="file_name",nullable = false, length = 255)
    private String fileName;

    @Column(name="file_path",nullable = false, length = 500)
    private String filePath;

    @Column(name="uploaded_at",updatable = false)
    private LocalDateTime uploadedAt = LocalDateTime.now();

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();

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