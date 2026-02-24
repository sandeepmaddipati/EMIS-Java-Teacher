package com.tns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	Optional<UserRole> findByUser_UserId(Long userId);

	
	
}
