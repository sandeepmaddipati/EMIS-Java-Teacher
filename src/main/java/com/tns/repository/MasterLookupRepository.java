package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.MasterLookup;

@Repository
public interface MasterLookupRepository
        extends JpaRepository<MasterLookup, Long> {

    Optional<MasterLookup>
        findByLookupTypeAndLookupValue(
            String lookupType, String lookupValue);

    List<MasterLookup>
        findByLookupTypeAndIsActiveTrue(String lookupType);
}
