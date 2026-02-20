package com.tns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.WorkExperience;
@Repository
public interface WorkExperienceRepository
        extends JpaRepository<WorkExperience, Long> {
	List<WorkExperience> findByTeacher_TeacherId(Long teacherId);
}
