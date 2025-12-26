package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;
import java.util.List;
import java.util.Optional;

public interface TeamSummaryService {
    TeamSummaryRecord saveTeamSummary(TeamSummaryRecord summary);
    Optional<TeamSummaryRecord> getSummaryById(Long id);
    List<TeamSummaryRecord> getAllSummaries();
}
