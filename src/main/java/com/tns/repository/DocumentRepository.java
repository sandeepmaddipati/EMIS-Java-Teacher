package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.Document;
@Repository
public interface DocumentRepository
        extends JpaRepository<Document, Long> {

    Optional<Document>
    findByDocumentIdAndTeacher_TeacherId(
            Long documentId, Long teacherId);

    List<Document>
    findByTeacher_TeacherId(Long teacherId);
}
