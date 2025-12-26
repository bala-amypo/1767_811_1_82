package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AnomalyFlagRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long metricId;
    private String ruleCode;
    private Boolean resolved = false;
    private LocalDateTime flaggedAt;

    @PrePersist
    public void onCreate() {
        flaggedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getMetricId() { return metricId; }
}
