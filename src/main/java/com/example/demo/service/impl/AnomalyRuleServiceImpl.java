package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public List<AnomalyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public AnomalyRule getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public void deactivateRule(String ruleCode) {
        AnomalyRule rule = getRuleByCode(ruleCode);
        rule.setActive(false);
        repository.save(rule);
    }
}
