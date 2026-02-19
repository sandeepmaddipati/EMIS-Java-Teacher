package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.TeachingQualification;
@Repository
public interface TeachingQualificationRepository
        extends JpaRepository<TeachingQualification, Long> {

    Optional<TeachingQualification>
    findByTeachingQualificationIdAndTeacher_TeacherId(
            Long id, Long teacherId);
}
