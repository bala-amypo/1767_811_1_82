package com.example.demo.service;

import com.example.demo.model.AnomalyRule;
import java.util.List;
import java.util.Optional;

public interface AnomalyRuleService {
    Optional<AnomalyRule> getRuleById(Long id);
    List<AnomalyRule> getActiveRules();
    AnomalyRule updateRule(Long id, AnomalyRule rule);
}
