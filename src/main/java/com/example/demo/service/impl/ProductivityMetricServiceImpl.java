package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.model.AnomalyRule;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.*;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository metricRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final AnomalyRuleRepository ruleRepo;
    private final AnomalyFlagRecordRepository flagRepo;

    // ⚠️ Constructor order EXACT
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

        metricRepo.findByEmployeeId(metric.getEmployeeId()).stream()
                .filter(m -> m.getDate().equals(metric.getDate()))
                .findFirst()
                .ifPresent(m -> {
                    throw new IllegalStateException("Metric already exists");
                });

        double score = ProductivityCalculator.computeScore(
                metric.getHoursLogged(),
                metric.getTasksCompleted(),
                metric.getMeetingsAttended()
        );

        score = Math.max(0, Math.min(100, score));

        metric.setProductivityScore(score);
        metric.setSubmittedAt(LocalDateTime.now());
        metric.setRawDataJson("{}");

        ProductivityMetricRecord saved = metricRepo.save(metric);

        List<AnomalyRule> rules = ruleRepo.findByActiveTrue();
        for (AnomalyRule rule : rules) {
            if (score < rule.getThresholdValue()) {
                AnomalyFlagRecord flag = new AnomalyFlagRecord();
                flag.setEmployeeId(saved.getEmployeeId());
                flag.setMetricId(saved.getId());
                flag.setRuleCode(rule.getRuleCode());
                flag.setSeverity("HIGH");
                flag.setDetails("Threshold breached");
                flag.setFlaggedAt(LocalDateTime.now());
                flag.setResolved(false);
                flagRepo.save(flag);
            }
        }

        return saved;
    }

    @Override
    public ProductivityMetricRecord getMetricById(Long id) {
        return metricRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return metricRepo.findByEmployeeId(employeeId);
    }
}
