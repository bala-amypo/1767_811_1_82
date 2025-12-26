package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {
    EmployeeProfile save(EmployeeProfile employee);
    List<EmployeeProfile> getAll();
    EmployeeProfile getByEmployeeId(String employeeId);
}
