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
    public ResponseEntity<TournamentStateDTO> createTournamentState(@RequestBody TournamentStateDTO tournamentState) {
        return tournamentStateService.createTournamentState(tournamentState); // change to accept DTO
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournamentStateDTO> updateTournamentState(@PathVariable("id") Integer id, @RequestBody TournamentStateDTO tournamentState) {
        Optional<TournamentStateDTO> tournamentStateUpdate = tournamentStateService.updateTournamentStateById(id, tournamentState); //update the service to accept DTO
        return tournamentStateUpdate.map(a -> ResponseEntity.ok(a)).orElseGet(() -> {
            return createTournamentState(tournamentState);
        });
    }
}
