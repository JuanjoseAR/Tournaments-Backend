package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
import com.tournaments.tournaments.dto.TournamentRegistrationMapper;
import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.repositories.TournamentRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentRegistrationServiceImp implements TournamentRegistrationService {

    private final TournamentRegistrationRepository tournamentRegistrationRepository;
    private final TournamentRegistrationMapper tournamentRegistrationMapper;

    public TournamentRegistrationServiceImp(TournamentRegistrationRepository tournamentRegistrationRepository,
                                            TournamentRegistrationMapper tournamentRegistrationMapper) {
        this.tournamentRegistrationRepository = tournamentRegistrationRepository;
        this.tournamentRegistrationMapper = tournamentRegistrationMapper;
    }

    @Override
    public Optional<TournamentRegistrationDTO> getTournamentRegistrationById(Integer id) {
        return tournamentRegistrationRepository.findById(id).map(tournamentRegistrationMapper::toDTO);
    }

    @Override
    public List<TournamentRegistrationDTO> getAllTournamentRegistrations() {
        return tournamentRegistrationRepository.findAll().stream()
                .map(dto->tournamentRegistrationMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public TournamentRegistrationDTO createTournamentRegistration(TournamentRegistrationDTO tournamentRegistrationDTO) {
        TournamentRegistration tournamentRegistration = tournamentRegistrationRepository
                .save(tournamentRegistrationMapper.toEntity(tournamentRegistrationDTO));
        return tournamentRegistrationMapper.toDTO(tournamentRegistration);
    }

    @Override
    public Optional<TournamentRegistrationDTO> updateTournamentRegistrationById(Integer id, TournamentRegistrationDTO tournamentRegistrationDTO) {
        TournamentRegistration newTournRegistr = tournamentRegistrationMapper.toEntity(tournamentRegistrationDTO);
        return tournamentRegistrationRepository.findById(id).map(
                tourRegInBD->{
                    tourRegInBD.setTrainerid(newTournRegistr.getTrainerid());
                    tourRegInBD.setTournamentid(newTournRegistr.getTournamentid());

                    return tournamentRegistrationRepository.save(tourRegInBD);
                }
        ).map(tournamentRegistrationMapper::toDTO);
    }

    @Override
    public void deleteTournamentRegistrationById(Integer id) {
        tournamentRegistrationRepository.deleteById(id);
    }
}
