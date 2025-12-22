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

    @PostMapping
    public AnomalyRule createRule(@RequestBody AnomalyRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public AnomalyRule updateRule(@PathVariable Long id,
                                  @RequestBody AnomalyRule rule) {
        return ruleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<AnomalyRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/{id}")
    public AnomalyRule getRuleById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @GetMapping
    public List<AnomalyRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
