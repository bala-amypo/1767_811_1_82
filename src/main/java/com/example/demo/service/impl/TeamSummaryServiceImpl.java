package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository teamRepo;

    public TeamSummaryServiceImpl(TeamSummaryRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    @Override
    public List<TeamSummaryRecord> getSummariesByTeam(String teamName) {
        return teamRepo.findByTeamName(teamName);
    }

    @Override
    public Optional<TeamSummaryRecord> getSummaryById(Long id) {
        return teamRepo.findById(id);
    }
}
