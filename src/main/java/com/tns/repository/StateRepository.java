package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.State;
import com.tns.model.WorkExperience;
@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByCountry_CountryIdAndIsActiveTrue(Long countryId);

	Optional<State> findByStateName(String stateName);
}
