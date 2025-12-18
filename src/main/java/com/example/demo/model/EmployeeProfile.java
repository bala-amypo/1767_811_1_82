package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;


@Entity
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String employeeId;
    private String fullName;
    @Column (unique = true)

    private String email;
    private String teamName;
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;

    public EmployeeProfile() {
    }

    public EmployeeProfile(Boolean active, String email, String employeeId, String fullName, Long id, String role, String teamName) {
        this.active = active;
        this.email = email;
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.id = id;
        this.role = role;
        this.teamName = teamName;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    


}
