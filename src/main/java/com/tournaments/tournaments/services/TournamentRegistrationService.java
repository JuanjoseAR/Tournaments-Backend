package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
import com.tournaments.tournaments.entities.TournamentRegistration;

import java.util.List;
import java.util.Optional;

public interface TournamentRegistrationService {
    Optional<TournamentRegistrationDTO> getTournamentRegistrationById(Integer id);
    Optional<TournamentRegistration> findTournamentRegistrationById(Integer id);
    List<TournamentRegistrationDTO> getAllTournamentRegistrations();
    TournamentRegistrationDTO createTournamentRegistration(TournamentRegistrationDTO tournamentRegistrationDTO);
    Optional<TournamentRegistrationDTO> updateTournamentRegistrationById(Integer id, TournamentRegistrationDTO tournamentRegistrationDTO);
    void deleteTournamentRegistrationById(Integer id);
}
