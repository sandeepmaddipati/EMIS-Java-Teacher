package com.tns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.DocumentRequest;
import com.tns.model.Document;
import com.tns.model.TeacherProfile;
import com.tns.repository.DocumentRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;

@Service
public class DocumentService {

    @Autowired private DocumentRepository repo;
    @Autowired private TeacherProfileRepository profileRepo;
    @Autowired private MasterLookupRepository lookupRepo;

    public String saveOrUpdate(DocumentRequest request){

        TeacherProfile teacher =
                profileRepo.findByUser_UserId(request.getUserId())
                        .orElseThrow(() ->
                                new RuntimeException("Teacher profile not found"));

        Document doc;

        if(request.getDocumentId() != null){
            doc = repo.findByDocumentIdAndTeacher_TeacherId(
                    request.getDocumentId(),
                    teacher.getTeacherId())
                    .orElseThrow(() ->
                            new RuntimeException("Document not found"));
        } else {
            doc = new Document();
            doc.setTeacher(teacher);
        }

        doc.setDocumentType(
                lookupRepo.findByLookupTypeAndLookupValue(
                        "DOCUMENT_TYPE",
                        request.getDocumentType())
                        .orElseThrow());

        doc.setFileName(request.getFileName());
        doc.setFilePath(request.getFilePath());

        repo.save(doc);

        return request.getDocumentId() != null
                ? "Document updated"
                : "Document uploaded";
    }




}

