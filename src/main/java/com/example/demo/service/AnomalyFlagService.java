package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;
import java.util.List;

public interface AnomalyFlagService {
    List<AnomalyFlagRecord> getAllFlags();
    List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId);
    List<AnomalyFlagRecord> getAnomaliesByMetric(Long metricId);
    AnomalyFlagRecord resolveAnomaly(Long id);
}
