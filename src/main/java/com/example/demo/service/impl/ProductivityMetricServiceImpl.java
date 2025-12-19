package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.repository.ProductivityMetricRecordRepository;
import com.example.demo.service.ProductivityMetricService;

@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    private final ProductivityMetricRecordRepository metricRepository;

    public ProductivityMetricServiceImpl(ProductivityMetricRecordRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public ProductivityMetricRecord saveMetric(ProductivityMetricRecord record) {
        return metricRepository.save(record);
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return metricRepository.findByEmployeeId(employeeId);
    }
}
