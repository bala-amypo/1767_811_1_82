package com.example.demo.service;

import com.example.demo.model.AnomalyRule;
import java.util.List;
import java.util.Optional;

public interface AnomalyRuleService {
    AnomalyRule createRule(AnomalyRule rule);
    Optional<AnomalyRule> getRuleByCode(String ruleCode);
    List<AnomalyRule> getActiveRules();
}
