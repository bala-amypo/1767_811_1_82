package com.example.demo.service;

import com.example.demo.model.AnomalyRule;
import java.util.List;
import java.util.Optional;

public interface AnomalyRuleService {

    AnomalyRule saveRule(AnomalyRule rule);

    List<AnomalyRule> getAllRules();

    Optional<AnomalyRule> getRuleById(Long id);
}
