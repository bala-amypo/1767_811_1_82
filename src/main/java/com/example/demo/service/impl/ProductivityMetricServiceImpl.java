package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.model.AnomalyRule;
import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository metricRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final AnomalyRuleRepository ruleRepo;
    private final AnomalyFlagRecordRepository flagRepo;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository metricRepo,
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
        if (metric.getHoursLogged() < 0 || metric.getTasksCompleted() < 0 || metric.getMeetingsAttended() < 0) {
            throw new IllegalArgumentException("Metrics values cannot be negative");
        }

        Long employeeId = metric.getEmployeeId();
        LocalDate date = metric.getDate();

        if (metricRepo.findByEmployeeIdAndDate(employeeId, date).isPresent()) {
            throw new IllegalStateException("Metric for this employee on this date already exists");
        }

        metric.setProductivityScore(ProductivityCalculator.computeScore(
                metric.getHoursLogged(),
                metric.getTasksCompleted(),
                metric.getMeetingsAttended()
        ));
        metric.setSubmittedAt(LocalDateTime.now());
        ProductivityMetricRecord savedMetric = metricRepo.save(metric);

        // Apply active anomaly rules
        List<AnomalyRule> activeRules = ruleRepo.findByActiveTrue();
        for (AnomalyRule rule : activeRules) {
            boolean triggered = false;
            switch (rule.getThresholdType()) {
                case "HOURS":
                    if (metric.getHoursLogged() < rule.getThresholdValue()) triggered = true;
                    break;
                case "TASKS":
                    if (metric.getTasksCompleted() < rule.getThresholdValue()) triggered = true;
                    break;
                case "SCORE":
                    if (metric.getProductivityScore() < rule.getThresholdValue()) triggered = true;
                    break;
            }
            if (triggered) {
                AnomalyFlagRecord flag = new AnomalyFlagRecord();
                flag.setEmployeeId(employeeId);
                flag.setMetricId(savedMetric.getId());
                flag.setRuleCode(rule.getRuleCode());
                flag.setSeverity("MEDIUM");
                flag.setDetails("Metric breached threshold: " + rule.getRuleCode());
                flag.setFlaggedAt(LocalDateTime.now());
                flag.setResolved(false);
                flagRepo.save(flag);
            }
        }

        return savedMetric;
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord updated) {
        ProductivityMetricRecord metric = metricRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));
        metric.setHoursLogged(updated.getHoursLogged());
        metric.setTasksCompleted(updated.getTasksCompleted());
        metric.setMeetingsAttended(updated.getMeetingsAttended());
        metric.setProductivityScore(ProductivityCalculator.computeScore(
                updated.getHoursLogged(),
                updated.getTasksCompleted(),
                updated.getMeetingsAttended()
        ));
        return metricRepo.save(metric);
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

    @Override
    public Optional<ProductivityMetricRecord> getMetricByEmployeeAndDate(Long employeeId, LocalDate date) {
        return metricRepo.findByEmployeeIdAndDate(employeeId, date);
    }
}
