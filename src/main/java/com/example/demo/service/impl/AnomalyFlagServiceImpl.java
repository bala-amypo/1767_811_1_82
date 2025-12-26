package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
        AnomalyFlagRecord flag = flagRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Anomaly not found"));
        flag.setResolved(true);
        return flagRepo.save(flag);
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId) {
        return flagRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByMetric(Long metricId) {
        return flagRepo.findByMetricId(metricId);
    }

    @Override
    public List<AnomalyFlagRecord> getAllAnomalies() {
        return flagRepo.findAll();
    }

    @Override
    public List<AnomalyFlagRecord> getUnresolvedFlags() {
        return flagRepo.findByResolvedFalse();
    }
}
