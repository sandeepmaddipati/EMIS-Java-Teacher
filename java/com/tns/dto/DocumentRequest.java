package com.tns.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DocumentRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Document type is required")
    private Long documentTypeId;

    @NotBlank(message = "File name is required")
    @Size(max = 255)
    private String fileName;

    @NotBlank(message = "File path is required")
    @Size(max = 500)
    private String filePath;

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
    
    
}