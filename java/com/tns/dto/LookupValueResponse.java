package com.tns.dto;

public class LookupValueResponse {

    private Long id;
    private String valueName;

    public LookupValueResponse() {
    }

    public LookupValueResponse(Long id, String valueName) {
        this.id = id;
        this.valueName = valueName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // ✅ added setter
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {   // ✅ added setter
        this.valueName = valueName;
    }
}