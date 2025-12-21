package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRecordRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository repository;

    public TeamSummaryServiceImpl(TeamSummaryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamSummaryRecord saveTeamSummary(TeamSummaryRecord summary) {
        return repository.save(summary);
    }

    @Override
    public List<TeamSummaryRecord> getSummariesByTeam(String teamName) {
        return repository.findByTeamName(teamName);
    }

    @Override
    public TeamSummaryRecord getSummaryById(Long id) {
        Optional<TeamSummaryRecord> summary = repository.findById(id);
        return summary.orElse(null); // or throw exception if needed
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return repository.findAll();
    }
}
