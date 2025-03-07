package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.ConfigurationParameter;
import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;

import java.util.List;
import java.util.Optional;

public interface ConfigurationParameterService {
    Optional<ConfigurationParameter> getConfigurationParameterById(Integer id);
    List<ConfigurationParameter> getAllConfigurationParameters();
    Optional<ConfigurationParameter> createConfigurationParameter(ConfigurationParameter configurationParameter);
    Optional<ConfigurationParameter> updateConfigurationParameterById(Integer id, ConfigurationParameter configurationParameter);
    void deleteConfigurationParameterById(Integer id);

}
