package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository flagRepo;

    public AnomalyFlagServiceImpl(AnomalyFlagRecordRepository flagRepo) {
        this.flagRepo = flagRepo;
    }

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag) {
        return flagRepo.save(flag);
    }

    @Override
    public AnomalyFlagRecord resolveAnomaly(Long id) {
        AnomalyFlagRecord existing = flagRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Flag not found"));
        existing.setResolved(true);
        return flagRepo.save(existing);
    }

    @Override
    public List<AnomalyFlagRecord> getByEmployee(Long employeeId) {
        return flagRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<AnomalyFlagRecord> getByMetric(Long metricId) {
        return flagRepo.findByMetricId(metricId);
    }

    @Override
    public List<AnomalyFlagRecord> getAllFlags() {
        return flagRepo.findAll();
    }
}
