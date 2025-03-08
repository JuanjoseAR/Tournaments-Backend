package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.entities.TournamentState;

import java.util.List;
import java.util.Optional;

public interface TournamentRegistrationService {
    Optional<TournamentRegistration> getTournamentRegistrationById(Integer id);
    List<TournamentRegistration> getAllTournamentRegistrations();
    TournamentRegistration createTournamentRegistration(TournamentRegistration tournamentRegistration);
    Optional<TournamentRegistration> updateTournamentRegistrationById(Integer id, TournamentRegistration tournamentRegistration);
    void deleteTournamentRegistrationById(Integer id);
}
