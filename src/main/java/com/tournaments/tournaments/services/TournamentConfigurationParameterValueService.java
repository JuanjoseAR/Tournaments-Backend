package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;
import com.tournaments.tournaments.entities.TournamentRegistration;

import java.util.List;
import java.util.Optional;

public interface TournamentConfigurationParameterValueService {
    Optional<TournamentConfigurationParameterValue> getTournamentConfigurationParameterValueById(Integer id);
    List<TournamentConfigurationParameterValue> getAllTournamentConfigurationParameterValues();
    TournamentConfigurationParameterValue createTournamentConfigurationParameterValue(TournamentConfigurationParameterValue tournamentConfigurationParameterValue);
    Optional<TournamentConfigurationParameterValue> updateTournamentConfigurationParameterValueById(Integer id, TournamentConfigurationParameterValue tournamentConfigurationParameterValue);
    void deleteTournamentConfigurationParameterValueById(Integer id);

}
