package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentDTO;

import java.util.List;
import java.util.Optional;

public interface TournamentService {
    Optional<TournamentDTO> getTournamentById(Integer id);
    List<TournamentDTO> getAllTournaments();
    TournamentDTO createTournament(TournamentDTO tournamentDTO);
    Optional<TournamentDTO> updateTournamentById(Integer id, TournamentDTO tournamentDTO);
    void deleteTournamentById(Integer id);
}
