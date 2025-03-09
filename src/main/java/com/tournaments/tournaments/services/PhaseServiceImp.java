package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.PhaseDTO;
import com.tournaments.tournaments.dto.PhaseMapper;
import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.repositories.PhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhaseServiceImp implements PhaseService {

    private final PhaseRepository phaseRepository;
    private final PhaseMapper phaseMapper;

    public PhaseServiceImp(PhaseRepository phaseRepository, PhaseMapper phaseMapper) {
        this.phaseRepository = phaseRepository;
        this.phaseMapper = phaseMapper;
    }

    @Override
    public Optional<PhaseDTO> getPhaseById(Integer id) {
        return phaseRepository.findById(id)
                .map(phaseMapper::toDTO);
    }

    @Override
    public List<PhaseDTO> getAllPhases() {
        return phaseRepository.findAll().stream()
                .map(dto->phaseMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public PhaseDTO createPhase(PhaseDTO phaseDTO) {
        Phase newPhase = phaseRepository.save(phaseMapper.toEntity(phaseDTO));
        return phaseMapper.toDTO(newPhase);
    }

    @Override
    public Optional<PhaseDTO> updatePhaseById(Integer id, PhaseDTO phaseDTO) {
        Phase newPhase = phaseMapper.toEntity(phaseDTO);
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
}
