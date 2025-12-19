package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;

import java.time.LocalDateTime;
import java.util.List;

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

        EmployeeProfile employee = employeeRepo.findById(metric.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (!employee.getActive()) {
            throw new RuntimeException("Employee not found");
        }

        boolean exists = metricRepo.findByEmployeeId(metric.getEmployeeId())
                .stream()
                .anyMatch(m -> m.getDate().equals(metric.getDate()));

        if (exists) {
            throw new IllegalStateException("Metric already exists");
        }

        double score = ProductivityCalculator.computeScore(
                metric.getHoursLogged(),
                metric.getTasksCompleted(),
                metric.getMeetingsAttended()
        );

        metric.setProductivityScore(Math.min(100, Math.max(0, score)));
        metric.setSubmittedAt(LocalDateTime.now());

        ProductivityMetricRecord saved = metricRepo.save(metric);

        ruleRepo.findByActiveTrue().forEach(rule -> {
            if (saved.getProductivityScore() < rule.getThresholdValue()) {
                AnomalyFlagRecord flag = new AnomalyFlagRecord(
                        null,
                        saved.getEmployeeId(),
                        saved.getId(),
                        rule.getRuleCode(),
                        "HIGH",
                        "Threshold breached",
                        LocalDateTime.now(),
                        false
                );
                flagRepo.save(flag);
            }
        });

        return saved;
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord updated) {
        ProductivityMetricRecord existing = getMetricById(id);

        existing.setHoursLogged(updated.getHoursLogged());
        existing.setTasksCompleted(updated.getTasksCompleted());
        existing.setMeetingsAttended(updated.getMeetingsAttended());

        double score = ProductivityCalculator.computeScore(
                updated.getHoursLogged(),
                updated.getTasksCompleted(),
                updated.getMeetingsAttended()
        );

        existing.setProductivityScore(Math.min(100, Math.max(0, score)));

        return metricRepo.save(existing);
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return metricRepo.findByEmployeeId(employeeId);
    }

    @Override
    public ProductivityMetricRecord getMetricById(Long id) {
        return metricRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return metricRepo.findAll();
    }
}
