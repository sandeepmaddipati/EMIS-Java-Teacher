package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.WorkExperience;
@Repository
public interface WorkExperienceRepository
        extends JpaRepository<WorkExperience, Long> {

    Optional<WorkExperience>
    findByWorkIdAndTeacher_TeacherId(
            Long workId, Long teacherId);
}
