package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.AcademicQualification;
@Repository
public interface AcademicQualificationRepository
        extends JpaRepository<AcademicQualification, Long> {

    Optional<AcademicQualification>
    findByAcademicQualificationIdAndTeacher_TeacherId(
            Long id, Long teacherId);

    List<AcademicQualification>
    findByTeacher_TeacherId(Long teacherId);
}
