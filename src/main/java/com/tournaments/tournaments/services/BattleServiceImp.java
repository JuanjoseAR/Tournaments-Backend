package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Battle;
import com.tournaments.tournaments.repositories.BattleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BattleServiceImp implements BattleService {
    private final BattleRepository battleRepository;

    public BattleServiceImp(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    @Override
    public List<Battle> getAllBattles() {
        return battleRepository.findAll();
    }

    @Override
    public Optional<Battle> getBattleById(Integer id) {
        return battleRepository.findById(id);
    }

    @Override
    public Battle createBattle(Battle battle) {
        return battleRepository.save(battle);
    }

    @Override
    public Optional<Battle> updateBattle(Integer id, Battle battle) {
        return battleRepository.findById(id).map(
                battleInDB-> {
                    battleInDB.setPhaseid(battle.getPhaseid());
                    battleInDB.setWinnerid(battle.getWinnerid());
                    battleInDB.setLoserid(battle.getLoserid());
                    battleInDB.setBattleduration(battle.getBattleduration());
                    return battleRepository.save(battleInDB);
                }
        );
    }

    @Override
    public void deleteBattleById(Integer id) {
        battleRepository.deleteById(id);
    }
}
