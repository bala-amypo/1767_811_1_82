package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.*;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service

public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository summaryRepo;
    private final ProductivityMetricRecordRepository metricRepo;

    public TeamSummaryServiceImpl(
            TeamSummaryRecordRepository summaryRepo,
            ProductivityMetricRecordRepository metricRepo) {
        this.summaryRepo = summaryRepo;
        this.metricRepo = metricRepo;
    }

    @Override
    public TeamSummaryRecord generateSummary(String teamName, LocalDate summaryDate) {
        TeamSummaryRecord t = new TeamSummaryRecord();
        t.setTeamName(teamName);
        t.setSummaryDate(summaryDate);
        return summaryRepo.save(t);
    }

    @Override
    public List<TeamSummaryRecord> getSummariesByTeam(String teamName) {
        return summaryRepo.findAll();
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return summaryRepo.findAll();
    }
}
