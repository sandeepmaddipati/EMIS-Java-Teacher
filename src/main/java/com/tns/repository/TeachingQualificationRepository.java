package com.tns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.TeachingQualification;
@Repository
public interface TeachingQualificationRepository extends JpaRepository<TeachingQualification, Long> {
    List<TeachingQualification> findByUserId(Long userId);
}