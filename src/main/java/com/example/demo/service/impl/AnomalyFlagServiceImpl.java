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
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord record) {
        return flagRepo.save(record);
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByEmployee(Long employeeId) {
        return flagRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<AnomalyFlagRecord> getUnresolvedFlags() {
        return flagRepo.findByResolvedFalse();
    }
}
 