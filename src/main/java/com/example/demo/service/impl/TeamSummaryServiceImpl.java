package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository summaryRepository;

    public TeamSummaryServiceImpl(TeamSummaryRepository summaryRepository) {
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
