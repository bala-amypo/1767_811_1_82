package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.AnomalyRuleRepository;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
            AnomalyFlagRecordRepository flagRepo
    ) {
        this.metricRepo = metricRepo;
        this.employeeRepo = employeeRepo;
        this.ruleRepo = ruleRepo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {

        // Duplicate check
        boolean exists = metricRepo
                .findByEmployeeId(record.getEmployeeId())
                .stream()
                .anyMatch(m -> m.getDate().equals(record.getDate()));

        if (exists) {
            throw new IllegalStateException("Metric already exists for this date");
        }

        // Compute score INLINE
        double score =
                record.getHoursLogged() * 10
                        + record.getTasksCompleted() * 5
                        + record.getMeetingsAttended() * 2;

        record.setProductivityScore(score);
        record.setSubmittedAt(LocalDateTime.now());

        return metricRepo.save(record);
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
