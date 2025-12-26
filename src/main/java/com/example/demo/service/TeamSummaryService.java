package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;

import java.util.List;

public interface TeamSummaryService {

    TeamSummaryRecord saveTeamSummary(TeamSummaryRecord summary);

    List<TeamSummaryRecord> getSummariesByTeam(String teamName);

    TeamSummaryRecord getSummaryById(Long id);

    List<TeamSummaryRecord> getAllSummaries();
}
