package com.example.demo.controller;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
public class AnomalyFlagController {

    private final AnomalyFlagService anomalyFlagService;

    public AnomalyFlagController(AnomalyFlagService anomalyFlagService) {
        this.anomalyFlagService = anomalyFlagService;
    }

    @PostMapping
    public AnomalyFlagRecord flagAnomaly(
            @RequestBody AnomalyFlagRecord anomalyFlagRecord) {
        return anomalyFlagService.flagAnomaly(anomalyFlagRecord);
    }

    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolveAnomaly(@PathVariable Long id) {
        return anomalyFlagService.resolveAnomaly(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(
            @PathVariable Long employeeId) {
        return anomalyFlagService.getAnomaliesByEmployee(employeeId);
    }

    @GetMapping("/metric/{metricId}")
    public List<AnomalyFlagRecord> getAnomaliesByMetric(
            @PathVariable Long metricId) {
        return anomalyFlagService.getAnomaliesByMetric(metricId);
    }

    @GetMapping
    public List<AnomalyFlagRecord> getAllAnomalies() {
        return anomalyFlagService.getAllAnomalies();
    }
}
