package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;

public interface AnomalyFlagRecordRepository {
    List<AnomalyFlagRecord> findByMetricId(Long metricId);
}
