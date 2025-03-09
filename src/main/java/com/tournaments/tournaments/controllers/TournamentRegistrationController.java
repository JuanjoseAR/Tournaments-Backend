package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.services.TournamentRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/tournament/register")

public class TournamentRegistrationController {
    private final TournamentRegistrationService tournamentRegistrationService;

    public TournamentRegistrationController(TournamentRegistrationService tournamentRegistrationService) {
        this.tournamentRegistrationService = tournamentRegistrationService;
    }

    @PostMapping
    public ResponseEntity<TournamentRegistrationDTO> createTournamentRegistration(@RequestBody TournamentRegistrationDTO tournamentRegistration) {
        return crearTournamentRegistration(tournamentRegistration);
    }

    private ResponseEntity<TournamentRegistrationDTO> crearTournamentRegistration(TournamentRegistrationDTO tournamentRegistration) {
        TournamentRegistrationDTO newTournamentRegistration = tournamentRegistrationService.createTournamentRegistration(tournamentRegistration);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTournamentRegistration.id()).toUri();
        return ResponseEntity.created(location).body(newTournamentRegistration);
    }
}
