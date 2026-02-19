package com.tns.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "master_lookup")
public class MasterLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lookup_id")
    private Long lookupId;

    @Column(name = "lookup_type")
    private String lookupType;

    @Column(name = "lookup_value")
    private String lookupValue;

    @Column(name = "is_active")
    private Boolean isActive;

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}

