package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.entities.Trainer;

import java.util.List;
import java.util.Optional;

public interface TournamentRegistrationService {
    Optional<TournamentRegistrationDTO> getTournamentRegistrationById(Integer id);
    Optional<TournamentRegistration> findTournamentRegistrationById(Integer id);
    List<TournamentRegistrationDTO> getAllTournamentRegistrations();
    TournamentRegistrationDTO createTournamentRegistration(TournamentRegistrationDTO tournamentRegistrationDTO);
    Optional<TournamentRegistrationDTO> updateTournamentRegistrationById(Integer id, TournamentRegistrationDTO tournamentRegistrationDTO);
    void deleteTournamentRegistrationById(Integer id);
    void registerTrainerForTournament(Integer tournamentId, Integer trainerId);
    boolean isTrainerRegistered(Integer tournamentId, Integer trainerId);
    List<Trainer> getRegistrationsByTournamentId(Integer tournamentId);
}
