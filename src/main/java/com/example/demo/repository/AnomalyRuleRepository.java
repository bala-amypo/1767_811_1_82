package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;

public interface AnomalyRuleRepository {
    List<AnomalyRule> findByActiveTrue();
}
