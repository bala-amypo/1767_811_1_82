package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile getEmployeeById(Long id);

    EmployeeProfile getEmployeeByEmployeeId(String employeeId);

    List<EmployeeProfile> getAllEmployees();

    EmployeeProfile updateEmployee(Long id, EmployeeProfile employee);

    void deactivateEmployee(Long id);
}
