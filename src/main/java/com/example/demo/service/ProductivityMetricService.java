package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;

import java.util.List;

public interface ProductivityMetricService {

    ProductivityMetricRecord saveMetric(ProductivityMetricRecord record);

    List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId);
}
