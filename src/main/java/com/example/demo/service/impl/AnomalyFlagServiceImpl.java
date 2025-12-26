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
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord record) {
        return anomalyRepo.save(record);
    }

    @Override
    public List<AnomalyFlagRecord> getAllAnomalies() {
        return anomalyRepo.findAll();
    }

    @Override
    public AnomalyFlagRecord resolveAnomaly(Long id) {
        AnomalyFlagRecord record = anomalyRepo.findById(id).orElse(null);
        if (record != null) {
            record.setResolved(true); // Assuming your entity has a 'resolved' field
            anomalyRepo.save(record);
        }
        return record;
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId) {
        return anomalyRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByMetric(Long metricId) {
        return anomalyRepo.findByMetricId(metricId);
    }
}
