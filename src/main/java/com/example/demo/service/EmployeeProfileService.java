package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;
import java.util.Optional;

public interface EmployeeProfileService {
    EmployeeProfile createEmployee(EmployeeProfile profile);
    EmployeeProfile getEmployeeById(Long id);
    List<EmployeeProfile> getByTeam(String teamName);
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
    EmployeeProfile updateEmployeeStatus(Long id, boolean active);
}
