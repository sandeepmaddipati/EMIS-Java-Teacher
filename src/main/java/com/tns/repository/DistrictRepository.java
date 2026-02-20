package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.District;
import com.tns.model.WorkExperience;
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    List<District> findByState_StateIdAndIsActiveTrue(Long stateId);

	Optional<District> findByDistrictName(String districtName);
}
