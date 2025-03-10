package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.TournamentDTO;
import com.tournaments.tournaments.services.TournamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournament")

public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public ResponseEntity<List<TournamentDTO>> getAllTournaments() {
        return  ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/{id}")
    public Optional<TournamentDTO> getTournament(@PathVariable("id") Integer id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentDTO tournament) {
        return crearTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable("id") Integer id) {
        tournamentService.deleteTournamentById(id);
    }

    private ResponseEntity<TournamentDTO> crearTournament(TournamentDTO tournament) {
        TournamentDTO newTournament = tournamentService.createTournament(tournament);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTournament.id()).toUri();
        return ResponseEntity.created(location).body(newTournament);
    }
}
