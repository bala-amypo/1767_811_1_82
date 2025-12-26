package com.example.demo.dto;

public class AnomalyFlagDto {

    private Long employeeId;
    private String severity;
    private String details;

    public AnomalyFlagDto() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getSeverity() {
        return severity;
    }
    
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
}
