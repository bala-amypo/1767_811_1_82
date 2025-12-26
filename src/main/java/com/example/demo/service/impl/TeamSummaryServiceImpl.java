package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.model.ProductivityMetricRecord;
import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.repository.ProductivityMetricRepository;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository summaryRepo;
    private final ProductivityMetricRepository metricRepo;
    private final AnomalyFlagRecordRepository flagRepo;

    public TeamSummaryServiceImpl(TeamSummaryRepository summaryRepo,
                                  ProductivityMetricRepository metricRepo,
                                  AnomalyFlagRecordRepository flagRepo) {
        this.summaryRepo = summaryRepo;
        this.metricRepo = metricRepo;
        this.flagRepo = flagRepo;
    }

    @Override
    public TeamSummaryRecord generateSummary(String teamName, LocalDate date) {
        List<ProductivityMetricRecord> metrics = metricRepo.findByEmployeeIdInTeam(teamName); // you may implement a custom query
        List<AnomalyFlagRecord> anomalies = flagRepo.findByEmployeeIdInTeamUnresolved(teamName); // custom query

        double avgHours = metrics.stream().mapToDouble(ProductivityMetricRecord::getHoursLogged).average().orElse(0.0);
        double avgTasks = metrics.stream().mapToInt(ProductivityMetricRecord::getTasksCompleted).average().orElse(0.0);
        double avgScore = metrics.stream().mapToDouble(ProductivityMetricRecord::getProductivityScore).average().orElse(0.0);
        int anomalyCount = anomalies.size();

        TeamSummaryRecord summary = new TeamSummaryRecord();
        summary.setTeamName(teamName);
        summary.setSummaryDate(date);
        summary.setAvgHoursLogged(avgHours);
        summary.setAvgTasksCompleted(avgTasks);
        summary.setAvgScore(avgScore);
        summary.setAnomalyCount(anomalyCount);
        summary.setGeneratedAt(LocalDate.now().atStartOfDay());

        return summaryRepo.save(summary);
    }
}
