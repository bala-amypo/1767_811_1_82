package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;

import java.time.LocalDate;

public interface TeamSummaryService {

    TeamSummaryRecord generateSummary(String teamName, LocalDate date);

    TeamSummaryRecord getSummary(String teamName, LocalDate date);
}
