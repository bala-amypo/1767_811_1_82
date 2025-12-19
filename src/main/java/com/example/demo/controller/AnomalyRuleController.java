package com.example.demo.controller;

import com.example.demo.model.AnomalyRule;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class AnomalyRuleController {

    private final AnomalyRuleService ruleService;

    public AnomalyRuleController(AnomalyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public AnomalyRule saveRule(@RequestBody AnomalyRule rule) {
        return ruleService.saveRule(rule);
    }

    @GetMapping("/active")
    public List<AnomalyRule> getActiveRules() {
        return ruleService.getActiveRules();
    }
}
