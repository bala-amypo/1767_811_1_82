package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.exception.ResourceNotFoundException;
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
    public List<AnomalyRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public AnomalyRule getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public AnomalyRule getRuleByCode(String code) {
        return ruleRepository.findByRuleCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with code: " + code));
    }

    @Override
    public AnomalyRule createRule(AnomalyRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public AnomalyRule updateRule(Long id, AnomalyRule updatedRule) {
        AnomalyRule existing = ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        // Always safe: ruleCode exists
        existing.setRuleCode(updatedRule.getRuleCode());

        // Update thresholdValue if present
        if (updatedRule.getThresholdValue() != null) {
            existing.setThresholdValue(updatedRule.getThresholdValue());
        }

        // If your entity had 'active', you could add it here safely
        // if (updatedRule.getActive() != null) {
        //     existing.setActive(updatedRule.getActive());
        // }

        return ruleRepository.save(existing);
    }
    @Override
public List<AnomalyRule> getActiveRules() {
    // Assuming 'active' field exists in AnomalyRule
    return ruleRepository.findByActiveTrue();
}


    @Override
    public void deleteRule(Long id) {
        AnomalyRule existing = ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
        ruleRepository.delete(existing);
    }
}
