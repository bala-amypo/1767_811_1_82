package com.example.demo.controller;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
@Tag(name = "Anomalies")
public class AnomalyFlagController {

    private final AnomalyFlagService flagService;

    public AnomalyFlagController(AnomalyFlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping
    public AnomalyFlagRecord flag(@RequestBody AnomalyFlagRecord flag) {
        return flagService.flagAnomaly(flag);
    }

    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolve(@PathVariable Long id) {
        return flagService.resolveFlag(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<AnomalyFlagRecord> byEmployee(@PathVariable Long employeeId) {
        return flagService.getFlagsByEmployee(employeeId);
    }

    @GetMapping("/metric/{metricId}")
    public List<AnomalyFlagRecord> byMetric(@PathVariable Long metricId) {
        return flagService.getFlagsByMetric(metricId);
    }

    @GetMapping
    public List<AnomalyFlagRecord> getAll() {
        return flagService.getAllFlags();
    }
}
