package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRecordRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository summaryRepo;

    public TeamSummaryServiceImpl(TeamSummaryRecordRepository summaryRepo) {
        this.summaryRepo = summaryRepo;
    }

    @Override
    public TeamSummaryRecord saveTeamSummary(TeamSummaryRecord record) {
        record.setGeneratedAt(LocalDateTime.now());
        return summaryRepo.save(record);
    }

    @Override
    public List<TeamSummaryRecord> getSummariesByTeam(String teamName) {
        return summaryRepo.findByTeamName(teamName);
    }

    @Override
    public TeamSummaryRecord getSummaryById(Long id) {
        return summaryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Summary not found"));
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return summaryRepo.findAll();
    }

    @Override
    public TeamSummaryRecord getSummary(String teamName, LocalDate date) {
        return summaryRepo.findByTeamNameAndDate(teamName, date)
                .orElseThrow(() -> new RuntimeException("Summary not found"));
    }
}
