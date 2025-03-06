package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Battle;

import java.util.List;
import java.util.Optional;

public interface BattleService {
    List<Battle> getAllBattles();
    Optional<Battle> getBattleById(Integer id);
    Battle createBattle(Battle battle);
    Optional<Battle> updateBattle(Integer id, Battle battle);
    void deleteBattleById(Integer id);
}
