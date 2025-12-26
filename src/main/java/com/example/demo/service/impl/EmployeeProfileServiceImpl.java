package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        employee.setCreatedAt(LocalDateTime.now());
        employee.setActive(true);
        return repository.save(employee);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public EmployeeProfile getEmployeeByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeeProfile updateEmployee(Long id, EmployeeProfile employee) {
        EmployeeProfile existing = getEmployeeById(id);
        existing.setFullName(employee.getFullName());
        existing.setEmail(employee.getEmail());
        existing.setTeamName(employee.getTeamName());
        existing.setTitle(employee.getTitle());
        return repository.save(existing);
    }

    @Override
    public void deactivateEmployee(Long id) {
        EmployeeProfile employee = getEmployeeById(id);
        employee.setActive(false);
        repository.save(employee);
    }
}
