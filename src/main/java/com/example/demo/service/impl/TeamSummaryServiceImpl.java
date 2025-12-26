package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository summaryRepo;

    public TeamSummaryServiceImpl(TeamSummaryRepository summaryRepo) {
        this.summaryRepo = summaryRepo;
    }

    @Override
    public TeamSummaryRecord generateSummary(String teamName) {
        TeamSummaryRecord record = new TeamSummaryRecord();
        record.setTeamName(teamName);
        return summaryRepo.save(record);
    }

    @Override
    public List<TeamSummaryRecord> getByTeam(String teamName) {
        return summaryRepo.findByTeamName(teamName);
    }

    @Override
    public TeamSummaryRecord getById(Long id) {
        return summaryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("TeamSummary not found"));
    }

    @Override
    public List<TeamSummaryRecord> getAll() {
        return summaryRepo.findAll();
    }
}
