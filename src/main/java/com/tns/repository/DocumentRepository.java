package com.tns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByUserId(Long userId);
}