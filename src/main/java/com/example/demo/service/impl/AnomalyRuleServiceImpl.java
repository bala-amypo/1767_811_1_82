package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
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
    public AnomalyRule updateRule(Long id, AnomalyRule rule) {
        AnomalyRule existing = ruleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        existing.setRuleCode(rule.getRuleCode());
        existing.setThresholdValue(rule.getThresholdValue());
        existing.setActive(rule.getActive());
        return ruleRepo.save(existing);
    }

    @Override
    public List<AnomalyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public AnomalyRule getRuleById(Long id) {
        return ruleRepo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public List<AnomalyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
