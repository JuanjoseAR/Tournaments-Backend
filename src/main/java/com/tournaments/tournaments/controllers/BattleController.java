package com.tournaments.tournaments.controllers;

import com.tournaments.tournaments.dto.BattleDTO;
import com.tournaments.tournaments.services.BattleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tournament/matches")

public class BattleController {
    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<BattleDTO> getMatchups(@PathVariable("id") Integer id) {
//        return battleService.getMatchupsById(id); //waiting44444
//    }

//    @PostMapping("/{id}")
//    public ResponseEntity<BattleDTO> createMatchups(@PathVariable("id") Integer id) {
//        return battleService.createMatchupsById(id); //same
//    }
}