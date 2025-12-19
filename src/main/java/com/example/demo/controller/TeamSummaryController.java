package com.example.demo.controller;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/teams")
public class TeamSummaryController {

    private final TeamSummaryService teamSummaryService;

    public TeamSummaryController(TeamSummaryService teamSummaryService) {
        this.teamSummaryService = teamSummaryService;
    }

    @PostMapping
    public TeamSummaryRecord saveSummary(
            @RequestBody TeamSummaryRecord summary) {
        return teamSummaryService.saveTeamSummary(summary);
    }

    @GetMapping("/{teamName}/{date}")
    public TeamSummaryRecord getSummary(
            @PathVariable String teamName,
            @PathVariable LocalDate date) {
        return teamSummaryService.getSummaryByTeamAndDate(teamName, date);
    }
}
