package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository anomalyRepo;

    public AnomalyFlagServiceImpl(AnomalyFlagRecordRepository anomalyRepo) {
        this.anomalyRepo = anomalyRepo;
    }

    @Override
    public List<AnomalyFlagRecord> getAllFlags() {
        return anomalyRepo.findAll();
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId) {
        return anomalyRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByMetric(Long metricId) {
        return anomalyRepo.findByMetricId(metricId);
    }

    @Override
    public AnomalyFlagRecord resolveAnomaly(Long id) {
        return anomalyRepo.findById(id).map(anomaly -> {
            anomaly.setResolved(true);
            return anomalyRepo.save(anomaly);
        }).orElse(null);
    }
}
