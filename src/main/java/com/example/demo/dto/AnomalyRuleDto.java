package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AnomalyRuleDto {

    @NotBlank
    private String ruleCode;

    private String thresholdType;

    @Positive
    private Double thresholdValue;

    public AnomalyRuleDto() {
    }

    public String getRuleCode() {
        return ruleCode;
    }
    
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getThresholdType() {
        return thresholdType;
    }
    
    public void setThresholdType(String thresholdType) {
        this.thresholdType = thresholdType;
    }

    public Double getThresholdValue() {
        return thresholdValue;
    }
    
    public void setThresholdValue(Double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }
}
