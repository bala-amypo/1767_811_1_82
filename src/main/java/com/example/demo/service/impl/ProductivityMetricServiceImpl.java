package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.*;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository metricRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final AnomalyRuleRepository ruleRepo;
    private final AnomalyFlagRecordRepository flagRepo;

    public ProductivityMetricServiceImpl(
            ProductivityMetricRecordRepository metricRepo,
            EmployeeProfileRepository employeeRepo,
            AnomalyRuleRepository ruleRepo,
            AnomalyFlagRecordRepository flagRepo) {

        this.metricRepo = metricRepo;
        this.employeeRepo = employeeRepo;
        this.ruleRepo = ruleRepo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric) {
        metric.setProductivityScore(
                ProductivityCalculator.computeScore(
                        metric.getHoursLogged(),
                        metric.getTasksCompleted(),
                        metric.getMeetingsAttended())
        );
        return metricRepo.save(metric);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord updated) {
        ProductivityMetricRecord existing = metricRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));
        updated.setProductivityScore(existing.getProductivityScore());
        return metricRepo.save(updated);
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return metricRepo.findByEmployeeId(employeeId);
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return metricRepo.findById(id);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return metricRepo.findAll();
    }
}
