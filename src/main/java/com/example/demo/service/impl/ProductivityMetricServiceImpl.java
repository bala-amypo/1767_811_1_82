package com.example.demo.service.impl;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository metricRepository;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        return metricRepository.save(record);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record) {
        ProductivityMetricRecord existing = metricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));
        record.setId(existing.getId());
        return metricRepository.save(record);
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return metricRepository.findByEmployeeId(employeeId);
    }

    @Override
    public ProductivityMetricRecord getMetricById(Long id) {
        return metricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metric not found"));
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return metricRepository.findAll();
    }
}
