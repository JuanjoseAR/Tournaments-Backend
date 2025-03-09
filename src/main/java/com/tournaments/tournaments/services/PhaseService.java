package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.PhaseDTO;
import com.tournaments.tournaments.entities.Phase;

import java.util.List;
import java.util.Optional;

public interface PhaseService {
    Optional<PhaseDTO> getPhaseById(Integer id);
    Optional<Phase> findPhaseById(Integer id);
    List<PhaseDTO> getAllPhases();
    PhaseDTO createPhase(PhaseDTO phaseDTO);
    Optional<PhaseDTO> updatePhaseById(Integer id, PhaseDTO phaseDTO);
    void deletePhaseById(Integer id);

}
