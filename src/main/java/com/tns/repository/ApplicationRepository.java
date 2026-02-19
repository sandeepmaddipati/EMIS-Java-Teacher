package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.Application;
@Repository
public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    Optional<Application>
    findByTeacher_TeacherId(Long teacherId);
}
