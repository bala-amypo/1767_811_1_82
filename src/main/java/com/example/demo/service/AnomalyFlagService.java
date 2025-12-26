package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;
import java.util.List;
import java.util.Optional;

public interface AnomalyFlagService {

    AnomalyFlagRecord saveFlag(AnomalyFlagRecord flag);

    List<AnomalyFlagRecord> getAllFlags();

    List<AnomalyFlagRecord> getFlagsByMetric(Long metricId);

    Optional<AnomalyFlagRecord> getFlagById(Long id);
}
