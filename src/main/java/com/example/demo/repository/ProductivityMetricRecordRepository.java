package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;

public interface ProductivityMetricRecordRepository {
    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
}
