package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.Optional;

public interface EmployeeProfileService {
    EmployeeProfile saveEmployee(EmployeeProfile employee);
    Optional<EmployeeProfile> getByEmployeeId(String employeeId);
}
