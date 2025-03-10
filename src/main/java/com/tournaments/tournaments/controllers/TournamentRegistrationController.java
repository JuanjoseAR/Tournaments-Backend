package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
import com.tournaments.tournaments.services.TournamentRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournament/register")

public class TournamentRegistrationController {
    private final TournamentRegistrationService tournamentRegistrationService;

    public TournamentRegistrationController(TournamentRegistrationService tournamentRegistrationService) {
        this.tournamentRegistrationService = tournamentRegistrationService;
    }

    @PostMapping("/{tournamentId}")
    public ResponseEntity<String> registerTrainer( @PathVariable("tournamentId") Integer tournamentId, @RequestParam Integer trainerId) {
        tournamentRegistrationService.registerTrainerForTournament(tournamentId, trainerId);
        return ResponseEntity.ok("Trainer registered successfully");
    }

    @GetMapping("/{tournamentId}")
    public ResponseEntity<List<TournamentRegistrationDTO>> getRegistrationsByTournamentId( @PathVariable("tournamentId") Integer tournamentId) {
        List<TournamentRegistrationDTO> registrations = tournamentRegistrationService.getRegistrationsByTournamentId(tournamentId);
        return ResponseEntity.ok(registrations);
    }
}
