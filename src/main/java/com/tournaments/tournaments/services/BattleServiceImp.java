package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.BattleDTO;
import com.tournaments.tournaments.dto.BattleMapper;
import com.tournaments.tournaments.entities.Battle;
import com.tournaments.tournaments.repositories.BattleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BattleServiceImp implements BattleService {
    private final BattleRepository battleRepository;
    private final BattleMapper battleMapper;

    public BattleServiceImp(BattleRepository battleRepository, BattleMapper battleMapper) {
        this.battleRepository = battleRepository;
        this.battleMapper = battleMapper;
    }

    @Override
    public List<BattleDTO> getAllBattles() {
        return battleRepository.findAll().stream()
                .map(dto->battleMapper.toDTO(dto))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BattleDTO> getBattleById(Integer id) {
        return battleRepository.findById(id).map(battleMapper::toDTO);
    }

    @Override
    public BattleDTO createBattle(BattleDTO battleDTO) {
        Battle battle = battleRepository.save(battleMapper.toEntity(battleDTO));
        return battleMapper.toDTO(battle);
    }

    @Override
    public Optional<BattleDTO> updateBattle(Integer id, BattleDTO battleDTO) {
        Battle battle = battleMapper.toEntity(battleDTO);
        return battleRepository.findById(id).map(
                battleInDB-> {
                    battleInDB.setPhaseid(battle.getPhaseid());
                    battleInDB.setWinnerid(battle.getWinnerid());
                    battleInDB.setLoserid(battle.getLoserid());
                    battleInDB.setBattleduration(battle.getBattleduration());
                    return battleRepository.save(battleInDB);
                }
        ).map(battleMapper::toDTO);
    }

    @Override
    public void deleteBattleById(Integer id) {
        battleRepository.deleteById(id);
    }
}
