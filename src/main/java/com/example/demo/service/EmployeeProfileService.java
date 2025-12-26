package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.Optional;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    Optional<EmployeeProfile> getEmployeeById(Long id);

    Optional<EmployeeProfile> getByEmployeeId(String employeeId);

    EmployeeProfile updateEmployee(EmployeeProfile employee);
}
    