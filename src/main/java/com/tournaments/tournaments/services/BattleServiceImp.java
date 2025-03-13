package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.BattleDTO;
import com.tournaments.tournaments.dto.BattleMapper;
import com.tournaments.tournaments.entities.Battle;
import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.entities.Trainer;
import com.tournaments.tournaments.repositories.BattleRepository;
import com.tournaments.tournaments.repositories.PhaseRepository;
import com.tournaments.tournaments.repositories.TournamentRegistrationRepository;
import com.tournaments.tournaments.repositories.TrainerRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BattleServiceImp implements BattleService {
    private final BattleRepository battleRepository;
    private final BattleMapper battleMapper;
    private final PhaseService  phaseService;
    private final TrainerService trainerService;
    private final TournamentRegistrationRepository tournamentRegistrationRepository;
    private final TrainerRepository trainerRepository;
    private final PhaseRepository phaseRepository;



    public BattleServiceImp(BattleRepository battleRepository, BattleMapper battleMapper, PhaseService phaseService, TrainerService trainerService, TournamentRegistrationRepository tournamentRegistrationRepository, TrainerRepository trainerRepository, PhaseRepository phaseRepository) {
        this.battleRepository = battleRepository;
        this.battleMapper = battleMapper;
        this.phaseService = phaseService;
        this.trainerService = trainerService;
        this.tournamentRegistrationRepository = tournamentRegistrationRepository;
        this.trainerRepository = trainerRepository;
        this.phaseRepository = phaseRepository;
    }

    @Override
    public List<BattleDTO> getAllBattles() {
        return battleRepository.findAll().stream()
                .map(battleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BattleDTO> getBattleById(Integer id) {
        return battleRepository.findById(id).map(battleMapper::toDTO);
    }

    @Override
    public Optional<Battle> findBattleById(Integer id) {
        return battleRepository.findById(id);
    }

    @Override
    public BattleDTO createBattle(BattleDTO battleDTO) {
        Battle battle = battleRepository.save(battleMapper.toEntity(battleDTO, phaseService, trainerService));
        return battleMapper.toDTO(battle);
    }

    @Override
    public Optional<BattleDTO> updateBattle(Integer id, BattleDTO battleDTO) {
        Battle battle = battleMapper.toEntity(battleDTO, phaseService, trainerService);
        return battleRepository.findById(id).map(
                battleInDB-> {
                    battleInDB.setPhase(battle.getPhase());
                    battleInDB.setFirstParticipant(battle.getFirstParticipant());
                    battleInDB.setSecondParticipant(battle.getSecondParticipant());
                    battleInDB.setWinner(battle.getWinner());
                    battleInDB.setBattleDuration(battle.getBattleDuration());
                    return battleRepository.save(battleInDB);
                }
        ).map(battleMapper::toDTO);
    }

    @Override
    public void deleteBattleById(Integer id) {
        battleRepository.deleteById(id);
    }

    // fix it
    public List<Battle> createMatchupsForTournament(Integer tournamentId) {
        List<Integer> trainerIds = tournamentRegistrationRepository.findTrainerIdsByTournamentId(tournamentId);
        Phase phase = phaseRepository.findById(8)
                .orElseThrow(() -> new RuntimeException("Phase not found in database!"));

        if (trainerIds.size() < 2) {
            throw new IllegalArgumentException("Not enough participants to create match-ups" + trainerIds.size());
        }

        List<Battle> battles = new ArrayList<>();
        for (int i = 0; i < trainerIds.size(); i += 2) {
            if (i + 1 < trainerIds.size()) {
                Trainer firstParticipant = trainerRepository.findById(trainerIds.get(i))
                        .orElseThrow(() -> new RuntimeException("Trainer not found"));
                Trainer secondParticipant = trainerRepository.findById(trainerIds.get(i + 1))
                        .orElseThrow(() -> new RuntimeException("Trainer not found"));
                Battle battle = new Battle();
                battle.setPhase(phase);
                battle.setFirstParticipant(firstParticipant);
                battle.setSecondParticipant(secondParticipant);
                battle.setWinner(firstParticipant);
                battle.setBattleDuration(Time.valueOf(LocalTime.of(1, 30, 0)));

                battles.add(battle);
            }
        }

        return battleRepository.saveAll(battles);
    }

    public Optional<Battle> getMatchupsById(Integer id) {
        return battleRepository.findById(id);
    }
}
