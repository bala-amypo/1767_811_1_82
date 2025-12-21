package com.example.demo.controller;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anomalies")
public class AnomalyFlagController {

    private final AnomalyFlagService anomalyFlagService;

    public AnomalyFlagController(AnomalyFlagService anomalyFlagService) {
        this.anomalyFlagService = anomalyFlagService;
    }
     @PostMapping
    public AnomalyRule saveRule(@RequestBody AnomalyRule rule) {
        return ruleService.saveRule(rule);
    }

    @GetMapping("/unresolved")
    public List<AnomalyFlagRecord> getUnresolvedAnomalies() {
        return anomalyFlagService.getUnresolvedAnomalies();
    }

    @GetMapping("/employee/{employeeId}")
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(
            @PathVariable Long employeeId) {
        return anomalyFlagService.getAnomaliesByEmployee(employeeId);
    }
}
