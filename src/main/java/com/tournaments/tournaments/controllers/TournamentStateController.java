package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.TournamentStateDTO;
import com.tournaments.tournaments.entities.TournamentState;
import com.tournaments.tournaments.services.TournamentStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tournament/status")

public class TournamentStateController {
    private final TournamentStateService tournamentStateService;

    public TournamentStateController(TournamentStateService tournamentStateService) {
        this.tournamentStateService = tournamentStateService;
    }

    @PostMapping
    public ResponseEntity<TournamentState> createTournamentState(@RequestBody TournamentState tournamentState) {
        TournamentState createdState = tournamentStateService.createTournamentState(tournamentState);
        return ResponseEntity.ok(createdState);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournamentState> updateTournamentState(@PathVariable("id") Integer id, @RequestBody TournamentState tournamentState) {
        Optional<TournamentState> updatedState = tournamentStateService.updateTournamentStateById(id, tournamentState);
        return updatedState.map(ResponseEntity::ok)
                .orElseGet(() -> createTournamentState(tournamentState));
    }}
