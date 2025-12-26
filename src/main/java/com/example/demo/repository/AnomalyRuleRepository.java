package com.example.demo.repository;

import com.example.demo.model.AnomalyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalyRuleRepository extends JpaRepository<AnomalyRule, Long> {
}
