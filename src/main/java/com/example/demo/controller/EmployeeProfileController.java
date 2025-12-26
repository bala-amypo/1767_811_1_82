package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee API", description = "APIs for Employee Profile management")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new employee profile")
    public EmployeeProfile createEmployee(@Valid @RequestBody EmployeeProfile employee) {
        return service.save(employee);
    }

    @GetMapping
    @Operation(summary = "Get all employee profiles")
    public List<EmployeeProfile> getAllEmployees() {
        return service.getAll();
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "Get employee profile by Employee ID")
    public EmployeeProfile getEmployeeById(@PathVariable String employeeId) {
        return service.getByEmployeeId(employeeId);
    }
}
