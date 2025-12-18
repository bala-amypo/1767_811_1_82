package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity
public class ProductivityMetricRecord {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long employeeId;
private LocalDate date;
private Double hoursLogged;
private int tasksCompleted;
private int metingsAttended;
private Double productivityScore;
private String rawDataJson;
private LocalDateTime submittedAt;


public ProductivityMetricRecord(LocalDateTime submittedAt) {
    this.submittedAt = submittedAt;
}

public ProductivityMetricRecord(Long id, Long employeeId, LocalDate date, Double hoursLogged, int tasksCompleted,
        int metingsAttended, Double productivityScore, String rawDataJson, LocalDateTime submittedAt) {
    this.id = id;
    this.employeeId = employeeId;
    this.date = date;
    this.hoursLogged = hoursLogged;
    this.tasksCompleted = tasksCompleted;
    this.metingsAttended = metingsAttended;
    this.productivityScore = productivityScore;
    this.rawDataJson = rawDataJson;
    this.submittedAt = submittedAt;
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
public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
}
public LocalDate getDate() {
    return date;
}
public void setDate(LocalDate date) {
    this.date = date;
}
public Double getHoursLogged() {
    return hoursLogged;
}
public void setHoursLogged(Double hoursLogged) {
    this.hoursLogged = hoursLogged;
}
public int getTasksCompleted() {
    return tasksCompleted;
}
public void setTasksCompleted(int tasksCompleted) {
    this.tasksCompleted = tasksCompleted;
}
public int getMetingsAttended() {
    return metingsAttended;
}
public void setMetingsAttended(int metingsAttended) {
    this.metingsAttended = metingsAttended;
}
public Double getProductivityScore() {
    return productivityScore;
}
public void setProductivityScore(Double productivityScore) {
    this.productivityScore = productivityScore;
}
public String getRawDataJson() {
    return rawDataJson;
}
public void setRawDataJson(String rawDataJson) {
    this.rawDataJson = rawDataJson;
}
public LocalDateTime getSubmittedAt() {
    return submittedAt;
}
public void setSubmittedAt(LocalDateTime submittedAt) {
    this.submittedAt = submittedAt;
}

}
