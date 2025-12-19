package com.example.demo.controller;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/team-summaries")
@Tag(name = "Team Summaries")
public class TeamSummaryController {

    private final TeamSummaryService summaryService;

    public TeamSummaryController(TeamSummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @PostMapping("/generate")
    public TeamSummaryRecord generate(@RequestParam String teamName,
                                      @RequestParam LocalDate summaryDate) {
        return summaryService.generateSummary(teamName, summaryDate);
    }

    @GetMapping("/team/{teamName}")
    public List<TeamSummaryRecord> byTeam(@PathVariable String teamName) {
        return summaryService.getSummariesByTeam(teamName);
    }

    @GetMapping
    public List<TeamSummaryRecord> getAll() {
        return summaryService.getAllSummaries();
    }
}
