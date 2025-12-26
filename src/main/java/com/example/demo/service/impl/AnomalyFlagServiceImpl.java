package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;

import java.util.List;
import java.util.Optional;

public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository repository;

    public AnomalyFlagServiceImpl(AnomalyFlagRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AnomalyFlagRecord saveFlag(AnomalyFlagRecord flag) {
        return repository.save(flag);
    }

    @Override
    public List<AnomalyFlagRecord> getAllFlags() {
        return repository.findAll();
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByMetric(Long metricId) {
        return repository.findByMetricId(metricId);
    }

    @Override
    public Optional<AnomalyFlagRecord> getFlagById(Long id) {
        return repository.findById(id);
    }
}
