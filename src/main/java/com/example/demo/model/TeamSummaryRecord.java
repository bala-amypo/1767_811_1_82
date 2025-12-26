package com.example.demo.model;

import java.time.LocalDate;

public class TeamSummaryRecord {

    private String teamName;
    private double avgHoursLogged;
    private double avgScore;
    private int anomalyCount;
    private LocalDate summaryDate;

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public double getAvgHoursLogged() { return avgHoursLogged; }
    public void setAvgHoursLogged(double avgHoursLogged) { this.avgHoursLogged = avgHoursLogged; }

    public double getAvgScore() { return avgScore; }
    public void setAvgScore(double avgScore) { this.avgScore = avgScore; }

    public int getAnomalyCount() { return anomalyCount; }
    public void setAnomalyCount(int anomalyCount) { this.anomalyCount = anomalyCount; }

    public LocalDate getSummaryDate() { return summaryDate; }
    public void setSummaryDate(LocalDate summaryDate) { this.summaryDate = summaryDate; }
}
