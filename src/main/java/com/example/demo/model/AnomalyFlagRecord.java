package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AnomalyFlagRecord {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
private Long employeeId;
private Long metricid;
private String ruleCode;
private String severity;

private String details;
private LocalDateTime flaggedAt=LocalDateTime.now();
private Boolean resolved =false;
public AnomalyFlagRecord() {
}

public AnomalyFlagRecord(Long id, Long employeeid, Long metricid, String ruleCode, String severity, String details,
        LocalDateTime flaggedAt, Boolean resolved) {
    this.id = id;
    this.employeeId = employeeId;
    this.metricid = metricid;
    this.ruleCode = ruleCode;
    this.severity = severity;
    this.details = details;
    this.flaggedAt = flaggedAt;
    this.resolved = resolved;
}

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Long getEmployeeId() {
    return employeeId;
}
public void setEmployeeid(Long employeeId) {
    this.employeeId = employeeId;
}
public Long getMetricid() {
    return metricid;
}
public void setMetricid(Long metricid) {
    this.metricid = metricid;
}
public String getRuleCode() {
    return ruleCode;
}
public void setRuleCode(String ruleCode) {
    this.ruleCode = ruleCode;
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
public LocalDateTime getFlaggedAt() {
    return flaggedAt;
}
public void setFlaggedAt(LocalDateTime flaggedAt) {
    this.flaggedAt = flaggedAt;
}
public Boolean getResolved() {
    return resolved;
}
public void setResolved(Boolean resolved) {
    this.resolved = resolved;
}


}
