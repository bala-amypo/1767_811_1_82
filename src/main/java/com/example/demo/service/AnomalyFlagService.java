package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;

import java.util.List;

public interface AnomalyFlagService {


    AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord anomalyFlagRecord);

    AnomalyFlagRecord resolveAnomaly(Long id);

    List<AnomalyFlagRecord> getAnomaliesByEmployee(Long employeeId);

    List<AnomalyFlagRecord> getAnomaliesByMetric(Long metricId);

    List<AnomalyFlagRecord> getAllAnomalies();
}
