package com.example.demo.service;

import com.example.demo.model.ProductivityMetricRecord;

import java.time.LocalDate;
import java.util.List;

public interface ProductivityMetricService {

    ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric);

    ProductivityMetricRecord getMetricById(Long id);

    List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId);

    ProductivityMetricRecord getMetricByEmployeeAndDate(
            Long employeeId,
            LocalDate date
    );
}
