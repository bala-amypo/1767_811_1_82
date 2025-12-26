package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Profile")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeProfile getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PutMapping("/{id}")
    public EmployeeProfile updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeProfile employee) {
        return service.updateEmployee(id, employee);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateEmployee(@PathVariable Long id) {
        service.deactivateEmployee(id);
    }

    @GetMapping("/lookup/{employeeId}")
    public EmployeeProfile lookupByEmployeeId(
            @PathVariable String employeeId) {
        return service.getEmployeeByEmployeeId(employeeId);
    }
}
