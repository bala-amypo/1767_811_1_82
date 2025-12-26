package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;
import java.util.List;

public interface TeamSummaryService {
    TeamSummaryRecord generateSummary(String teamName);
    List<TeamSummaryRecord> getByTeam(String teamName);
    TeamSummaryRecord getById(Long id);
    List<TeamSummaryRecord> getAll();
}
