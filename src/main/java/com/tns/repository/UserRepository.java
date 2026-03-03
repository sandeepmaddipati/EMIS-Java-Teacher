package com.tns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tns.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFullname(String fullname);

    Optional<User> findByEmail(String email);

    @Query("""
        SELECT DISTINCT u FROM User u
        LEFT JOIN FETCH u.userRoles ur
        LEFT JOIN FETCH ur.role
    """)
    List<User> findAllWithRoles();
}