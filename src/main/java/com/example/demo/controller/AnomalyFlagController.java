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

    // POST / - Flag anomaly
    @PostMapping
    public AnomalyFlagRecord flag(@RequestBody AnomalyFlagRecord flag) {
        return service.flagAnomaly(flag);
    }

    // PUT /{id}/resolve - Resolve anomaly
    @PutMapping("/{id}/resolve")
    public AnomalyFlagRecord resolve(@PathVariable Long id) {
        return service.resolveAnomaly(id);
    }

    // GET /employee/{employeeId}
    @GetMapping("/employee/{employeeId}")
    public List<AnomalyFlagRecord> getByEmployee(@PathVariable Long employeeId) {
        return service.getByEmployee(employeeId);
    }

    // GET /metric/{metricId}
    @GetMapping("/metric/{metricId}")
    public List<AnomalyFlagRecord> getByMetric(@PathVariable Long metricId) {
        return service.getByMetric(metricId);
    }

    // GET /
    @GetMapping
    public List<AnomalyFlagRecord> getAll() {
        return service.getAllFlags();
    }
}
