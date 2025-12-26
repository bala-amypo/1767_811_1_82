package com.example.demo.service;

import com.example.demo.model.AnomalyRule;

import java.util.List;

public interface AnomalyRuleService {

    AnomalyRule createRule(AnomalyRule rule);

    List<AnomalyRule> getActiveRules();

    AnomalyRule getRuleByCode(String ruleCode);

    void deactivateRule(String ruleCode);
}
