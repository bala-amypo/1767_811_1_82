package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"employeeId", "date"})
)
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private LocalDate date;
    private Double hoursLogged;
    private Integer tasksCompleted;
    private Integer meetingsAttended;
    private Double productivityScore;

    @Column(columnDefinition = "TEXT")
    private String rawDataJson;

    private LocalDateTime submittedAt;

    @PrePersist
    public void onCreate() {
        submittedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Double getHoursLogged() { return hoursLogged; }
    public void setHoursLogged(Double hoursLogged) { this.hoursLogged = hoursLogged; }
    public Integer getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(Integer tasksCompleted) { this.tasksCompleted = tasksCompleted; }
    public Integer getMeetingsAttended() { return meetingsAttended; }
    public void setMeetingsAttended(Integer meetingsAttended) { this.meetingsAttended = meetingsAttended; }
    public void setProductivityScore(Double productivityScore) { this.productivityScore = productivityScore; }
}
