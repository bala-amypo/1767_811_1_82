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

    // POST / - Create rule
    @PostMapping
    public AnomalyRule create(@RequestBody AnomalyRule rule) {
        return service.createRule(rule);
    }

    // PUT /{id} - Update rule
    @PutMapping("/{id}")
    public AnomalyRule update(@PathVariable Long id,
                              @RequestBody AnomalyRule rule) {
        return service.updateRule(id, rule);
    }

    // GET /active - List active rules
    @GetMapping("/active")
    public List<AnomalyRule> getActive() {
        return service.getActiveRules();
    }

    // GET /{id} - Get rule
    @GetMapping("/{id}")
    public AnomalyRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    // GET / - List all
    @GetMapping
    public List<AnomalyRule> getAll() {
        return service.getAllRules();
    }
}
