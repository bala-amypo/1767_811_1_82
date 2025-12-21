package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService employeeService;

    public EmployeeProfileController(EmployeeProfileService employeeService) {
        this.employeeService = employeeService;
    }

    // POST /api/employees – Create employee
    @PostMapping
    public ResponseEntity<EmployeeProfile> createEmployee(@Valid @RequestBody EmployeeProfile employee) {
        EmployeeProfile savedEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // GET /api/employees/{id} – Get by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfile> getEmployeeById(@PathVariable Long id) {
        EmployeeProfile employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // GET /api/employees – List all
    @GetMapping
    public ResponseEntity<List<EmployeeProfile>> getAllEmployees() {
        List<EmployeeProfile> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // PUT /api/employees/{id}/status – Update status (QP requirement)
    @PutMapping("/{id}/status")
    public ResponseEntity<EmployeeProfile> updateStatus(@PathVariable Long id,
                                                        @RequestParam String status) {
        EmployeeProfile updatedEmployee = employeeService.updateEmployeeStatus(id, status);
        return ResponseEntity.ok(updatedEmployee);
    }

    // GET /api/employees/lookup/{employeeId} – Lookup by employeeId
    @GetMapping("/lookup/{employeeId}")
    public ResponseEntity<EmployeeProfile> getByEmployeeId(@PathVariable String employeeId) {
        EmployeeProfile employee = employeeService.getByEmployeeId(employeeId);
        return ResponseEntity.ok(employee);
    }
}
