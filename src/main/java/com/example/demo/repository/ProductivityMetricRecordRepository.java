package com.example.demo.repository;

import com.example.demo.model.ProductivityMetricRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductivityMetricRepository extends JpaRepository<ProductivityMetricRecord, Long> {
    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
    Optional<ProductivityMetricRecord> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
