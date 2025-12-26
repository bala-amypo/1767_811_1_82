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

    // POST / - Record metric
    @PostMapping
    public ProductivityMetricRecord create(@RequestBody ProductivityMetricRecord record) {
        return service.recordMetric(record);
    }

    // PUT /{id} - Update metric
    @PutMapping("/{id}")
    public ProductivityMetricRecord update(@PathVariable Long id,
                                           @RequestBody ProductivityMetricRecord record) {
        return service.updateMetric(id, record);
    }

    // GET /employee/{employeeId} - Get employee metrics
    @GetMapping("/employee/{employeeId}")
    public List<ProductivityMetricRecord> getByEmployee(@PathVariable Long employeeId) {
        return service.getMetricsByEmployee(employeeId);
    }

    // GET /{id} - Get metric
    @GetMapping("/{id}")
    public ProductivityMetricRecord getById(@PathVariable Long id) {
        return service.getMetricById(id).orElseThrow();
    }

    // GET / - List all
    @GetMapping
    public List<ProductivityMetricRecord> getAll() {
        return service.getAllMetrics();
    }
}
