package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.PersonalInfo;
@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
    Optional<PersonalInfo> findByUser_UserId(Long userId);
}	