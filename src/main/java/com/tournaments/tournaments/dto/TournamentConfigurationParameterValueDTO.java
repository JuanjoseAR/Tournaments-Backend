package com.tournaments.tournaments.dto;

public record TournamentConfigurationParameterValueDTO(
        Integer id,
        Integer tournament,
        Integer configurationParameter,
        String value
) {}
