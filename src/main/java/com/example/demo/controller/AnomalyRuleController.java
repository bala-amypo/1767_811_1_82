package com.example.demo.controller;

import com.example.demo.model.AnomalyRule;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomaly-rules")
public class AnomalyRuleController {

    private final AnomalyRuleService ruleService;

    public AnomalyRuleController(AnomalyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // POST /api/anomaly-rules – Create rule
    @PostMapping
    public AnomalyRule createRule(@RequestBody AnomalyRule rule) {
        return ruleService.createRule(rule);
    }

    // PUT /api/anomaly-rules/{id} – Update rule
    @PutMapping("/{id}")
    public AnomalyRule updateRule(@PathVariable Long id,
                                  @RequestBody AnomalyRule rule) {
        return ruleService.updateRule(id, rule);
    }

    // GET /api/anomaly-rules/active – Get active rules
    @GetMapping("/active")
    public List<AnomalyRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    // GET /api/anomaly-rules/{id} – Get rule by id
    @GetMapping("/{id}")
    public AnomalyRule getRuleById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    // GET /api/anomaly-rules – List all rules
    @GetMapping
    public List<AnomalyRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
