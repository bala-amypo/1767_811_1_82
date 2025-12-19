package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.service.ProductivityMetricService;

@RestController
@RequestMapping("/productivity")
public class ProductivityMetricController {

    private final ProductivityMetricService productivityService;

    public ProductivityMetricController(ProductivityMetricService productivityService) {
        this.productivityService = productivityService;
    }

    @PostMapping
    public ProductivityMetricRecord saveMetric(
            @RequestBody ProductivityMetricRecord record) {
        return productivityService.saveMetric(record);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ProductivityMetricRecord> getMetricsByEmployee(
            @PathVariable Long employeeId) {
        return productivityService.getMetricsByEmployee(employeeId);
    }
}
