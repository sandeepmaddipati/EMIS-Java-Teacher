package com.tns.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="roles")

public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long roleId;
	
	@Column(name="role_name",unique=true)
	private String roleName;
	
	private String description;
	
    @Column(name="is_active")
    private Boolean isActive = true;
   
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;	

	public Role() {
		super();
	}

	public Role(Long roleId, String roleName, String description, Boolean isActive, LocalDateTime createdAt) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    
}
