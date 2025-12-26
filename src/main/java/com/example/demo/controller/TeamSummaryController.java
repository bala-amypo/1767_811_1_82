package com.example.demo.controller;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/team-summaries")
@Tag(name = "Team Summary")
public class TeamSummaryController {

    private final TeamSummaryService service;

    public TeamSummaryController(TeamSummaryService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public TeamSummaryRecord generateSummary(
            @RequestParam String teamName,
            @RequestParam LocalDate summaryDate) {
        return service.generateSummary(teamName, summaryDate);
    }

    @GetMapping("/team/{teamName}")
    public TeamSummaryRecord getByTeam(
            @PathVariable String teamName) {
        return service.getSummaryByTeam(teamName);
    }

    @GetMapping
    public List<TeamSummaryRecord> getAllSummaries() {
        return service.getAllSummaries();
    }
}
