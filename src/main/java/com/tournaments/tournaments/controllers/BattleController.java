package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.entities.Battle;
import com.tournaments.tournaments.services.BattleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournament/matches")

public class BattleController {
    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/{tournamentId}")
    public ResponseEntity<List<Battle>> generateMatchups( @PathVariable("tournamentId") Integer tournamentId) {
        List<Battle> battles = battleService.createMatchupsForTournament(tournamentId);
        return ResponseEntity.ok(battles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Battle>> getMatchups(@PathVariable("id") Integer id) {
        Optional<Battle> battle = battleService.getMatchupsById(id);
        return ResponseEntity.ok(battle);
    }
}