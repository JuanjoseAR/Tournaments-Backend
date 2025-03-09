package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentConfigurationParameterValueDTO;
import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;

import java.util.List;
import java.util.Optional;

public interface TournamentConfigurationParameterValueService {
    Optional<TournamentConfigurationParameterValueDTO> getTournamentConfigurationParameterValueById(Integer id);
    Optional<TournamentConfigurationParameterValue> findTournamentConfigurationParameterValueById(Integer id);
    List<TournamentConfigurationParameterValueDTO> getAllTournamentConfigurationParameterValues();
    TournamentConfigurationParameterValueDTO createTournamentConfigurationParameterValue(TournamentConfigurationParameterValueDTO tournamentConfigurationParameterValueDTO);
    Optional<TournamentConfigurationParameterValueDTO> updateTournamentConfigurationParameterValueById(Integer id, TournamentConfigurationParameterValueDTO tournamentConfigurationParameterValueDTO);
    void deleteTournamentConfigurationParameterValueById(Integer id);

}
