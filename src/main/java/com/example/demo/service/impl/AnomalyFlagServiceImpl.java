package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRepository repository;

    public AnomalyFlagServiceImpl(AnomalyFlagRepository repository) {
        this.repository = repository;
    }

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord anomalyFlagRecord) {
        return repository.save(anomalyFlagRecord);
    }

    @Override
    public AnomalyFlagRecord resolveAnomaly(Long id) {
        AnomalyFlagRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anomaly not found"));
        record.setResolved(true);
        return repository.save(record);
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByMetric(Long metricId) {
        return repository.findByMetricId(metricId);
    }

    @Override
    public List<AnomalyFlagRecord> getAllAnomalies() {
        return repository.findAll();
    }
}
