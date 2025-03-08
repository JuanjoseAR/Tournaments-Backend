package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.EliminationFormat;
import com.tournaments.tournaments.entities.Phase;

import java.util.List;
import java.util.Optional;

public interface PhaseService {
    Optional<Phase> getPhaseById(Integer id);
    List<Phase> getAllPhases();
    Phase createPhase(Phase phase);
    Optional<Phase> updatePhaseById(Integer id, Phase phase);
    void deletePhaseById(Integer id);

}
