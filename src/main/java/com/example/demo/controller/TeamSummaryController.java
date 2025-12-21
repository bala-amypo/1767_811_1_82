package com.example.demo.controller;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team-summaries")
public class TeamSummaryController {

    private final TeamSummaryService teamSummaryService;

    public TeamSummaryController(TeamSummaryService teamSummaryService) {
        this.teamSummaryService = teamSummaryService;
    }

    // POST /generate - generate summary
    @PostMapping("/generate")
    public TeamSummaryRecord generateSummary(@RequestBody TeamSummaryRecord summary) {
        return teamSummaryService.saveTeamSummary(summary);
    }

    // GET /team/{teamName} - get by team
    @GetMapping("/team/{teamName}")
    public List<TeamSummaryRecord> getByTeam(@PathVariable String teamName) {
        return teamSummaryService.getSummariesByTeam(teamName);
    }

    // GET /{id} - get by ID
    @GetMapping("/{id}")
    public TeamSummaryRecord getById(@PathVariable Long id) {
        return teamSummaryService.getSummaryById(id);
    }

    // GET / - list all
    @GetMapping
    public List<TeamSummaryRecord> getAllSummaries() {
        return teamSummaryService.getAllSummaries();
    }
}
