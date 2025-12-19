package com.example.demo.repository;

import com.example.demo.model.ProductivityMetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductivityMetricRepository
        extends JpaRepository<ProductivityMetricRecord, Long> {

    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
}
