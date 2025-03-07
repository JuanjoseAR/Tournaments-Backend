package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.entities.Trainer;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    Optional<Tournament> getTournamentById(Integer id);
    List<Tournament> getAllTournaments();
    Optional<Tournament> createTournament(Tournament tournament);
    Optional<Tournament> updateTournamentById(Integer id, Tournament tournament);
    void deleteTournamentById(Integer id);
}
