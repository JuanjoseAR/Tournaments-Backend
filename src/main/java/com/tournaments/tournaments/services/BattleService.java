package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.BattleDTO;

import java.util.List;
import java.util.Optional;

public interface BattleService {
    List<BattleDTO> getAllBattles();
    Optional<BattleDTO> getBattleById(Integer id);
    BattleDTO createBattle(BattleDTO battle);
    Optional<BattleDTO> updateBattle(Integer id, BattleDTO battleDTO);
    void deleteBattleById(Integer id);
}
