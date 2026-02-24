package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.LookupCategory;
@Repository
public interface LookupCategoryRepository 
        extends JpaRepository<LookupCategory, Long> {

    Optional<LookupCategory> findByCategoryKeyAndIsActiveTrue(String categoryKey);
}