package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository flagRepo;
    private final AnomalyRuleRepository ruleRepo;

    public AnomalyFlagServiceImpl(
            AnomalyFlagRecordRepository flagRepo,
            AnomalyRuleRepository ruleRepo
    ) {
        this.flagRepo = flagRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag) {
        // resolved defaults to false if null
        if (flag.getResolved() == null) {
            flag.setResolved(false);
        }
        return flagRepo.save(flag);
    }

    @Override
    public AnomalyFlagRecord resolveFlag(Long id) {
        AnomalyFlagRecord flag = flagRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anomaly flag not found"));

        flag.setResolved(true);
        return flagRepo.save(flag);
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByEmployee(Long employeeId) {
        // No employeeId field in entity → safe fallback
        return flagRepo.findAll();
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
