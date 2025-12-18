package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;



@Entity
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique  =true)
    private String employeeId;
    private String fullname;
    @Column(unique  =true)

    private String email;
    private String teamName;
    private String role;
    private Boolean active;
    @PreP
    private LocalDateTime createdAt =LocalDateTime.now();

    public EmployeeProfile(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EmployeeProfile(Long id, String employeeId, String fullname, String email, String teamName, String role,
            Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.fullname = fullname;
        this.email = email;
        this.teamName = teamName;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
