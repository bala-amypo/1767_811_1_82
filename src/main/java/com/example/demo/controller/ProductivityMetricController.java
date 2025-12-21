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

    // POST /api/metrics – Record metric
    @PostMapping
    public ProductivityMetricRecord recordMetric(
            @RequestBody ProductivityMetricRecord record) {
        return productivityService.recordMetric(record);
    }

    // PUT /api/metrics/{id} – Update metric
    @PutMapping("/{id}")
    public ProductivityMetricRecord updateMetric(
            @PathVariable Long id,
            @RequestBody ProductivityMetricRecord record) {
        return productivityService.updateMetric(id, record);
    }

    // GET /api/metrics/employee/{employeeId} – Get by employee
    @GetMapping("/employee/{employeeId}")
    public List<ProductivityMetricRecord> getMetricsByEmployee(
            @PathVariable Long employeeId) {
        return productivityService.getMetricsByEmployee(employeeId);
    }

    // GET /api/metrics/{id} – Get by id
    @GetMapping("/{id}")
    public ProductivityMetricRecord getMetricById(@PathVariable Long id) {
        return productivityService.getMetricById(id);
    }

    // GET /api/metrics – List all
    @GetMapping
    public List<ProductivityMetricRecord> getAllMetrics() {
        return productivityService.getAllMetrics();
    }
}
