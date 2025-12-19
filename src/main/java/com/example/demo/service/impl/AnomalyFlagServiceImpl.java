package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyFlagService;

import java.util.List;

public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository flagRepo;
    private final AnomalyRuleRepository ruleRepo;

    // REQUIRED constructor
    public AnomalyFlagServiceImpl(
            AnomalyFlagRecordRepository flagRepo,
            AnomalyRuleRepository ruleRepo) {

        this.flagRepo = flagRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag) {
        return flagRepo.save(flag);
    }

    @Override
    public AnomalyFlagRecord resolveFlag(Long id) {
        AnomalyFlagRecord flag = flagRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Flag not found"));

        flag.setResolved(true);
        return flagRepo.save(flag);
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByEmployee(Long employeeId) {
        return flagRepo.findAll().stream()
                .filter(f -> f.getEmployeeId().equals(employeeId))
                .toList();
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByMetric(Long metricId) {
        return flagRepo.findByMetricId(metricId);
    }

    @Override
    public List<AnomalyFlagRecord> getAllFlags() {
        return flagRepo.findAll();
    }
}
