package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile saveEmployee(EmployeeProfile employee);

    EmployeeProfile getEmployeeById(Long id);

    List<EmployeeProfile> getAllEmployees();
}
