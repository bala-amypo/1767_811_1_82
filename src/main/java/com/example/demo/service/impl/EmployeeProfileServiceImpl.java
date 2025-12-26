package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository employeeRepo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeProfile saveEmployee(EmployeeProfile employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Optional<EmployeeProfile> getByEmployeeId(String employeeId) {
        return employeeRepo.findByEmployeeId(employeeId);
    }
}
