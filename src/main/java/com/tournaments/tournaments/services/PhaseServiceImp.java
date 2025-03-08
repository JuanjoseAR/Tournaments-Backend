package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.repositories.PhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhaseServiceImp implements PhaseService {

    private PhaseRepository phaseRepository;

    public PhaseServiceImp(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    @Override
    public Optional<Phase> getPhaseById(Integer id) {
        return phaseRepository.findById(id);
    }

    @Override
    public List<Phase> getAllPhases() {
        return phaseRepository.findAll();
    }

    @Override
    public Phase createPhase(Phase phase) {
        return phaseRepository.save(phase);
    }

    @Override
    public Optional<Phase> updatePhaseById(Integer id, Phase phase) {
        return phaseRepository.findById(id).map(
                phaseInBD->{
                    phaseInBD.setName(phase.getName());
                    phaseInBD.setDescription(phase.getDescription());
                    return phaseRepository.save(phaseInBD);
                }
        );
    }

    @Override
    public void deletePhaseById(Integer id) {
        phaseRepository.deleteById(id);
    }
}
