package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRepository anomalyRepo;

    public AnomalyFlagServiceImpl(AnomalyFlagRepository anomalyRepo) {
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
}
