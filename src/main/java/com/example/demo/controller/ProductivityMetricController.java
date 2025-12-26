package com.example.demo.controller;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
@Tag(name = "Productivity Metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService service;

    public ProductivityMetricController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord recordMetric(
            @RequestBody ProductivityMetricRecord metric) {
        return service.recordMetric(metric);
    }

    @GetMapping("/{id}")
    public ProductivityMetricRecord getMetric(@PathVariable Long id) {
        return service.getMetricById(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ProductivityMetricRecord> getMetricsByEmployee(
            @PathVariable Long employeeId) {
        return service.getMetricsByEmployee(employeeId);
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAllMetrics() {
        return service.getAllMetrics();
    }
}
