package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;
import java.util.List;
import java.util.Optional;

public interface TeamSummaryService {
    List<TeamSummaryRecord> getSummariesByTeam(String teamName);
    Optional<TeamSummaryRecord> getSummaryById(Long id);
}
