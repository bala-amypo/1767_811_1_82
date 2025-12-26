package com.example.demo.controller;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService productivityService;

    public ProductivityMetricController(ProductivityMetricService productivityService) {
        this.productivityService = productivityService;
    }

    @PostMapping
    public ProductivityMetricRecord recordMetric(
            @RequestBody ProductivityMetricRecord record) {
        return productivityService.recordMetric(record);
    }

    @PutMapping("/{id}")
    public ProductivityMetricRecord updateMetric(
            @PathVariable Long id,
            @RequestBody ProductivityMetricRecord record) {
        return productivityService.updateMetric(id, record);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ProductivityMetricRecord> getMetricsByEmployee(
            @PathVariable Long employeeId) {
        return productivityService.getMetricsByEmployee(employeeId);
    }

    @GetMapping("/{id}")
    public ProductivityMetricRecord getMetricById(@PathVariable Long id) {
        return productivityService.getMetricById(id);
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAllMetrics() {
        return productivityService.getAllMetrics();
    }
}
