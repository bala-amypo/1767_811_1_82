package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;
import java.util.List;

public interface AnomalyFlagService {
    AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag);
    AnomalyFlagRecord resolveAnomaly(Long id);
    List<AnomalyFlagRecord> getByEmployee(Long employeeId);
    List<AnomalyFlagRecord> getByMetric(Long metricId);
    List<AnomalyFlagRecord> getAllFlags();
}
