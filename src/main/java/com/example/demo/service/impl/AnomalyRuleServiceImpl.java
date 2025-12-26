package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    private final AnomalyRuleRepository ruleRepo;

    public AnomalyRuleServiceImpl(AnomalyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public Optional<AnomalyRule> getRuleById(Long id) {
        return ruleRepo.findById(id);
    }

    @Override
    public List<AnomalyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public AnomalyRule updateRule(Long id, AnomalyRule updatedRule) {
        return ruleRepo.findById(id).map(rule -> {
            rule.setName(updatedRule.getName());
            rule.setActive(updatedRule.isActive());
            return ruleRepo.save(rule);
        }).orElse(null);
    }
}
