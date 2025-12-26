package com.example.demo.controller;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
@Tag(name = "Anomaly Flags")
public class AnomalyFlagController {

    private final AnomalyFlagService service;

    public AnomalyFlagController(AnomalyFlagService service) {
        this.service = service;
    }

    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolveFlag(@PathVariable Long id) {
        return service.resolveFlag(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<AnomalyFlagRecord> getByEmployee(
            @PathVariable Long employeeId) {
        return service.getFlagsByEmployee(employeeId);
    }

    @GetMapping("/metric/{metricId}")
    public List<AnomalyFlagRecord> getByMetric(
            @PathVariable Long metricId) {
        return service.getFlagsByMetric(metricId);
    }

    @GetMapping
    public List<AnomalyFlagRecord> getAllFlags() {
        return service.getAllFlags();
    }
}
