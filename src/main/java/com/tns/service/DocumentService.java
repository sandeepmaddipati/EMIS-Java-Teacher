package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.DocumentRequest;
import com.tns.dto.DocumentResponse;
import com.tns.model.Document;
import com.tns.model.MasterLookup;
import com.tns.model.TeacherProfile;
import com.tns.repository.DocumentRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;

@Service
public class DocumentService {
    @Autowired private DocumentRepository repo;
    @Autowired private TeacherProfileRepository teacherRepo;
    @Autowired private MasterLookupRepository lookupRepo;

    public String saveOrUpdate(DocumentRequest req) {
        Document d = (req.getDocumentId() != null)
            ? repo.findById(req.getDocumentId()).orElse(new Document())
            : new Document();

        TeacherProfile teacher = teacherRepo.findById(req.getTeacherId())
            .orElseThrow(() -> new RuntimeException("Teacher not found"));

        MasterLookup docType = lookupRepo.findByLookupTypeAndLookupValue("DOCUMENT_TYPE", req.getDocumentType())
            .orElseThrow(() -> new RuntimeException("Invalid document type"));

        d.setTeacher(teacher);
        d.setDocumentType(docType);
        d.setFileName(req.getFileName());
        d.setFilePath(req.getFilePath());
        repo.save(d);

        return req.getDocumentId() != null
            ? "Document updated successfully"
            : "Document added successfully";

    }

    public List<DocumentResponse> getAllByTeacher(Long teacherId) {
        return repo.findByTeacher_TeacherId(teacherId).stream().map(this::map).toList();
    }

    private DocumentResponse map(Document d) {
        DocumentResponse r = new DocumentResponse();
        r.setDocumentId(d.getDocumentId());
        r.setDocumentType(d.getDocumentType()!=null?d.getDocumentType().getLookupValue():null);
        r.setFileName(d.getFileName());
        r.setFilePath(d.getFilePath());
        r.setUploadedAt(d.getUploadedAt());
        return r;
    }
}