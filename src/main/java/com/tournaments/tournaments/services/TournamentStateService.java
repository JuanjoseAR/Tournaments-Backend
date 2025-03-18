package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.entities.TournamentState;

import java.util.List;
import java.util.Optional;

public interface TournamentStateService {
    Optional<TournamentState> getTournamentStateById(Integer id);
    List<TournamentState> getAllTournamentStates();
    TournamentState createTournamentState(TournamentState tournamentState);
    Optional<TournamentState> updateTournamentStateById(Integer id, TournamentState tournamentState);
    void deleteTournamentStateById(Integer id);
    TournamentState getTournamentStateByName(String name);

}
