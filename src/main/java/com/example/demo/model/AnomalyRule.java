package com.example.demo.model;

public class AnomalyRule {
    private String ruleCode;
    private double thresholdValue;
    private boolean active;

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public double getThresholdValue() { return thresholdValue; }
    public void setThresholdValue(double thresholdValue) { this.thresholdValue = thresholdValue; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
