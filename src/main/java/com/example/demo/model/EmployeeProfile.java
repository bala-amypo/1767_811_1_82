package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_profiles")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String employeeId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String teamName;
    private String title;
    private Boolean active = true;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
