package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;

import java.util.List;
import java.util.Optional;

public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository repository;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AnomalyRule saveRule(AnomalyRule rule) {
        return rule;
    }

    @Override
    public List<AnomalyRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public Optional<AnomalyRule> getRuleById(Long id) {
        return repository.findById(id);
    }
}
