package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository ruleRepo;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public AnomalyRule createRule(AnomalyRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public AnomalyRule updateRule(Long id, AnomalyRule updatedRule) {
        AnomalyRule rule = ruleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        rule.setRuleCode(updatedRule.getRuleCode());
        rule.setThresholdType(updatedRule.getThresholdType());
        rule.setThresholdValue(updatedRule.getThresholdValue());
        rule.setActive(updatedRule.isActive());
        return ruleRepo.save(rule);
    }

    @Override
    public AnomalyRule getRuleById(Long id) {
        return ruleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public List<AnomalyRule> getAllRules() {
        return ruleRepo.findAll();
    }

    @Override
    public List<AnomalyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }
}
