package com.example.demo.controller;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team-summaries")
@Tag(name = "Team Summary")
public class TeamSummaryController {

    private final TeamSummaryService service;

    public TeamSummaryController(TeamSummaryService service) {
        this.service = service;
    }

    // POST /generate
    @PostMapping("/generate")
    public TeamSummaryRecord generate(@RequestParam String teamName) {
        return service.generateSummary(teamName);
    }

    // GET /team/{teamName}
    @GetMapping("/team/{teamName}")
    public List<TeamSummaryRecord> getByTeam(@PathVariable String teamName) {
        return service.getByTeam(teamName);
    }

    // GET /{id}
    @GetMapping("/{id}")
    public TeamSummaryRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET /
    @GetMapping
    public List<TeamSummaryRecord> getAll() {
        return service.getAll();
    }
}
