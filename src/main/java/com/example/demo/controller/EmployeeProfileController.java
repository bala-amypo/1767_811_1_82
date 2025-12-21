package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
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
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee) {
        return employeeService.createEmployee(employee);
    }

    // GET /api/employees/{id} – Get by id
    @GetMapping("/{id}")
    public EmployeeProfile getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // GET /api/employees – List all
    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // PUT /api/employees/{id}/status – Update status (QP requirement)
    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(@PathVariable Long id,
                                        @RequestParam String status) {
        return employeeService.updateEmployeeStatus(id, status);
    }

    // GET /api/employees/lookup/{employeeId} – Lookup by employeeId
    @GetMapping("/lookup/{employeeId}")
    public EmployeeProfile getByEmployeeId(@PathVariable String employeeId) {
        return employeeService.getByEmployeeId(employeeId);
    }
}
