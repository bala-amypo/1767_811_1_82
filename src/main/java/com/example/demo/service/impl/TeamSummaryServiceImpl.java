package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRecordRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository summaryRepo;

    public TeamSummaryServiceImpl(TeamSummaryRecordRepository summaryRepo) {
        this.summaryRepo = summaryRepo;
    }

    @Override
    public TeamSummaryRecord saveTeamSummary(TeamSummaryRecord summary) {
        return summaryRepo.save(summary);
    }

    @Override
    public Optional<TeamSummaryRecord> getSummaryById(Long id) {
        return summaryRepo.findById(id);
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return summaryRepo.findAll();
    }
}
