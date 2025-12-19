package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRepository flagRepository;

    public AnomalyFlagServiceImpl(AnomalyFlagRepository flagRepository) {
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
