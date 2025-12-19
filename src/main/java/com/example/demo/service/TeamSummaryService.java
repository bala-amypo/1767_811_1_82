package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;

import java.time.LocalDate;

public interface TeamSummaryService {

    TeamSummaryRecord saveTeamSummary(TeamSummaryRecord summary);

    TeamSummaryRecord getSummaryByTeamAndDate(String teamName, LocalDate date);
}
