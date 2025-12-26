package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;

import java.util.List;

public interface AnomalyFlagService {

    List<AnomalyFlagRecord> getFlagsByEmployee(Long employeeId);

    List<AnomalyFlagRecord> getFlagsByMetric(Long metricId);

    List<AnomalyFlagRecord> getUnresolvedFlags();

    AnomalyFlagRecord resolveFlag(Long flagId);
}
