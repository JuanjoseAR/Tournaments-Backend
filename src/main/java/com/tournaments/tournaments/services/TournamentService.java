package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentDTO;
import com.tournaments.tournaments.entities.Tournament;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    Optional<TournamentDTO> getTournamentById(Integer id);
    Optional<Tournament> findTournamentById(Integer id);
    List<TournamentDTO> getAllTournaments();
    TournamentDTO createTournament(TournamentDTO tournamentDTO);
    Optional<TournamentDTO> updateTournamentById(Integer id, TournamentDTO tournamentDTO);
    void deleteTournamentById(Integer id);
}
