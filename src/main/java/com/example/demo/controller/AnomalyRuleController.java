package com.example.demo.controller;

import com.example.demo.model.AnomalyRule;
import com.example.demo.service.AnomalyRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomaly-rules")
@Tag(name = "Anomaly Rules")
public class AnomalyRuleController {

    private final AnomalyRuleService ruleService;

    public AnomalyRuleController(AnomalyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public AnomalyRule create(@RequestBody AnomalyRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public AnomalyRule update(@PathVariable Long id,
                              @RequestBody AnomalyRule updated) {
        return ruleService.updateRule(id, updated);
    }

    @GetMapping("/active")
    public List<AnomalyRule> activeRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/{id}")
    public AnomalyRule getById(@PathVariable Long id) {
        return ruleService.getAllRules()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping
    public List<AnomalyRule> getAll() {
        return ruleService.getAllRules();
    }
}
