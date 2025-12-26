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

    private final AnomalyRuleService service;

    public AnomalyRuleController(AnomalyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public AnomalyRule createRule(@RequestBody AnomalyRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{ruleCode}/deactivate")
    public void deactivateRule(@PathVariable String ruleCode) {
        service.deactivateRule(ruleCode);
    }

    @GetMapping("/active")
    public List<AnomalyRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{ruleCode}")
    public AnomalyRule getRule(@PathVariable String ruleCode) {
        return service.getRuleByCode(ruleCode);
    }
}
