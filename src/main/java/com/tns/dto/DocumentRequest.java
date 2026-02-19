package com.tns.dto;

import jakarta.validation.constraints.*;

public class DocumentRequest {

    private Long documentId;

    @NotNull
    private Long userId;

    @NotBlank
    private String documentType;

    @NotBlank
    @Size(max = 255)
    private String fileName;

    @NotBlank
    @Size(max = 500)
    private String filePath;

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

  
}
