package com.example.demo.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRecordRepository;
import com.example.demo.service.TeamSummaryService;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository summaryRepository;

    public TeamSummaryServiceImpl(TeamSummaryRecordRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    @Override
    public TeamSummaryRecord saveTeamSummary(TeamSummaryRecord summary) {
        return summaryRepository.save(summary);
    }

    @Override
    public TeamSummaryRecord getSummaryByTeamAndDate(String teamName, LocalDate date) {
        return summaryRepository
                .findByTeamNameAndSummaryDate(teamName, date)
                .orElse(null);
    }
}
