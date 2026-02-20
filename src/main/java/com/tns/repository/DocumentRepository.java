package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.Document;
import com.tns.model.MasterLookup;
@Repository
public interface DocumentRepository
        extends JpaRepository<Document, Long> {


    List<Document>
    findByTeacher_TeacherId(Long teacherId);

	
}
