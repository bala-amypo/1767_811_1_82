package com.example.demo.service;

import com.example.demo.model.AnomalyRule;
import java.util.List;

public interface AnomalyRuleService {
    List<AnomalyRule> getAllRules();
    AnomalyRule getRuleById(Long id);
    AnomalyRule getRuleByCode(String code);
    List<AnomalyRule> getActiveRules();
    AnomalyRule createRule(AnomalyRule rule);
    AnomalyRule updateRule(Long id, AnomalyRule updatedRule);
    void deleteRule(Long id);
}
