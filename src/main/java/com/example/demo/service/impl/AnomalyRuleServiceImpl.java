package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository ruleRepository;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public AnomalyRule createRule(AnomalyRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public AnomalyRule updateRule(Long id, AnomalyRule updatedRule) {
        AnomalyRule existing = ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        // DO NOT call setId() — entity has no setter
        existing.setRuleCode(updatedRule.getRuleCode());
        existing.setDescription(updatedRule.getDescription());
        existing.setThresholdType(updatedRule.getThresholdType());
        existing.setThresholdValue(updatedRule.getThresholdValue());
        existing.setActive(updatedRule.getActive());

        return ruleRepository.save(existing);
    }

    @Override
    public List<AnomalyRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }

    @Override
    public AnomalyRule getRuleByCode(String ruleCode) {
        return ruleRepository.findAll()
                .stream()
                .filter(r -> ruleCode.equals(r.getRuleCode()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<AnomalyRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
