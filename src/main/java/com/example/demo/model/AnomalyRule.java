package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AnomalyRule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private String description;
    private String thresholdType;
    private Double thresholdValue;
    private Boolean active = true;

    public Long getId() { return id; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public Double getThresholdValue() { return thresholdValue; }
    public void setThresholdValue(Double thresholdValue) { this.thresholdValue = thresholdValue; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getThresholdType() { return thresholdType; }
    public void setThresholdType(String thresholdType) { this.thresholdType = thresholdType; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
