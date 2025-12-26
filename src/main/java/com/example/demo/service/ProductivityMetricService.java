package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;
import java.util.List;
import java.util.Optional;

public interface ProductivityMetricService {

    ProductivityMetricRecord saveMetric(ProductivityMetricRecord record);

    Optional<ProductivityMetricRecord> getMetricById(Long id);

    List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId);

    List<ProductivityMetricRecord> getAllMetrics();
}
