package com.example.demo.model;

public class EmployeeProfile {
    private Long id;
    private String employeeId;
    private String fullName;
    private String email;
    private boolean active = true;
    private String teamName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
}
