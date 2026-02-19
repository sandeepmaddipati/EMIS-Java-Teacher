package com.tns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByIsActiveTrue();
}
