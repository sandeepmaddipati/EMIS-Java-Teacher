package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByFullname(String fullname);
    Optional<User> findByEmail(String email);
}