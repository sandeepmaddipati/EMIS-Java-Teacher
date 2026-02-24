package com.tns.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lookup_categories")
public class LookupCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long categoryId;

    @Column(name="category_key", unique = true, nullable = false)
    private String categoryKey;   // e.g., "genders"

    @Column(name="category_name", nullable = false)
    private String categoryName;  // e.g., "Genders"

    @Column(name="table_name", nullable = false)
    private String tableName;     // e.g., "genders"

    @Column(name="id_column", nullable = false)
    private String idColumn;      // e.g., "gender_id"

    @Column(name="value_column", nullable = false)
    private String valueColumn;   // e.g., "gender_name"

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated = LocalDateTime.now();

    // Getters and Setters
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryKey() { return categoryKey; }
    public void setCategoryKey(String categoryKey) { this.categoryKey = categoryKey; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getTableName() { return tableName; }
    public void setTableName(String tableName) { this.tableName = tableName; }

    public String getIdColumn() { return idColumn; }
    public void setIdColumn(String idColumn) { this.idColumn = idColumn; }

    public String getValueColumn() { return valueColumn; }
    public void setValueColumn(String valueColumn) { this.valueColumn = valueColumn; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}