package com.tns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.AcademicQualification;
@Repository
public interface AcademicQualificationRepository extends JpaRepository<AcademicQualification, Long> {
    List<AcademicQualification> findByUser_UserId(Long userId);
}