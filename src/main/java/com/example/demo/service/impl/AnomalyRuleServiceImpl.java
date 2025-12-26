package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;

import java.util.List;

public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository repository;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AnomalyRule createRule(AnomalyRule rule) {
        return repository.save(rule);
    }

    @Override
    public AnomalyRule updateRule(Long id, AnomalyRule updatedRule) {
        AnomalyRule existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        updatedRule.setRuleCode(existing.getRuleCode());
        return repository.save(updatedRule);
    }

    @Override
    public List<AnomalyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public AnomalyRule getRuleByCode(String ruleCode) {
        return repository.findAll().stream()
                .filter(r -> ruleCode.equals(r.getRuleCode()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public List<AnomalyRule> getAllRules() {
        return repository.findAll();
    }
}
