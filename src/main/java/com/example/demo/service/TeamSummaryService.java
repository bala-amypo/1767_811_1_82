package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TeamSummaryService {
    TeamSummaryRecord generateSummary(String teamName, LocalDate summaryDate);
    List<TeamSummaryRecord> getSummariesByTeam(String teamName);
    Optional<TeamSummaryRecord> getSummaryById(Long id);
    List<TeamSummaryRecord> getAllSummaries();
}
