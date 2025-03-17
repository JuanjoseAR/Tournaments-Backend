package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.PhaseDTO;
import com.tournaments.tournaments.dto.PhaseMapper;
import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.repositories.BattleRepository;
import com.tournaments.tournaments.repositories.PhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhaseServiceImp implements PhaseService {

    private final PhaseRepository phaseRepository;
    private final BattleRepository battleRepository;
    private final PhaseMapper phaseMapper;
    private final TournamentService tournamentService;

    public PhaseServiceImp(PhaseRepository phaseRepository, BattleRepository battleRepository, PhaseMapper phaseMapper, TournamentService tournamentService) {
        this.phaseRepository = phaseRepository;
        this.battleRepository = battleRepository;
        this.phaseMapper = phaseMapper;
        this.tournamentService = tournamentService;
    }

    @Override
    public Optional<PhaseDTO> getPhaseById(Integer id) {
        return phaseRepository.findById(id)
                .map(phaseMapper::toDTO);
    }

    @Override
    public Optional<Phase> findPhaseById(Integer id) {
        return phaseRepository.findById(id);
    }

    @Override
    public List<PhaseDTO> getAllPhases() {
        return phaseRepository.findAll().stream()
                .map(phaseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PhaseDTO createPhase(PhaseDTO phaseDTO) {
        Phase newPhase = phaseRepository.save(phaseMapper.toEntity(phaseDTO, tournamentService));
        return phaseMapper.toDTO(newPhase);
    }

    @Override
    public Optional<PhaseDTO> updatePhaseById(Integer id, PhaseDTO phaseDTO) {
        Phase newPhase = phaseMapper.toEntity(phaseDTO, tournamentService);
        return phaseRepository.findById(id).map(
                phaseInBD->{
                    phaseInBD.setName(newPhase.getName());
                    phaseInBD.setDescription(newPhase.getDescription());
                    return phaseRepository.save(phaseInBD);
                }
        ).map(phaseMapper::toDTO);
    }

    @Override
    public void deletePhaseById(Integer id) {
        phaseRepository.deleteById(id);
    }

    @Override
    public Phase getPhaseByTournamentId(Integer tournamentId) {
        List<Phase> phases = phaseRepository.findByTournamentId(tournamentId);

        for (Phase phase : phases) {
            boolean hasPendingBattles = battleRepository.existsByPhaseIdAndWinnerIsNull(phase.getId());

            if (hasPendingBattles) {
                return phase;
            }
        }

        if (!phases.isEmpty()) {
            return phases.get(phases.size() - 1);
        }

        return null;
    }

    @Override
    public List<Phase> getAllPhasesByTournamentId(Integer tournamentId) {
        return phaseRepository.findByTournamentId(tournamentId);
    }
}
