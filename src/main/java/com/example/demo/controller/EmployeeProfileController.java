package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Profile")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    // POST / - Create employee
    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    // GET /{id} - Get employee
    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // GET / - List all
    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAllEmployees();
    }

    // PUT /{id}/status - Update status
    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(@PathVariable Long id,
                                        @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }

    // GET /lookup/{employeeId} - Lookup
    @GetMapping("/lookup/{employeeId}")
    public Optional<EmployeeProfile> lookup(@PathVariable String employeeId) {
        return service.findByEmployeeId(employeeId);
    }
}
