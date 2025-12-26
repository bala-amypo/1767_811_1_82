package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRepository;
import com.example.demo.service.ProductivityMetricService;
import com.example.demo.util.ProductivityCalculator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRepository metricRepo;

    public ProductivityMetricServiceImpl(ProductivityMetricRepository metricRepo) {
        this.metricRepo = metricRepo;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        Optional<ProductivityMetricRecord> existing =
                metricRepo.findByEmployeeIdAndDate(record.getEmployeeId(), record.getDate());
        if (existing.isPresent()) throw new IllegalStateException("Metric exists");

        double score = ProductivityCalculator.computeScore(
                record.getHoursLogged(),
                record.getTasksCompleted(),
                record.getMeetingsAttended()
        );
        record.setProductivityScore(score);

        return metricRepo.save(record);
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
