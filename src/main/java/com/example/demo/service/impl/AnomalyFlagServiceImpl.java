package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository flagRepository;

    public AnomalyFlagServiceImpl(AnomalyFlagRecordRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    @Override
    public List<AnomalyFlagRecord> getUnresolvedAnomalies() {
        return flagRepository.findByResolvedFalse();
    }

    @Override
    public List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId) {
        return flagRepository.findByEmployeeId(employeeId);
    }
}
