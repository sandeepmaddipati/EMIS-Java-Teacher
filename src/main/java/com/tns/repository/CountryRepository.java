package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.model.Country;
import com.tns.model.TeacherProfile;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByIsActiveTrue();

	Optional<Country> findByCountryName(String countryName);
}
