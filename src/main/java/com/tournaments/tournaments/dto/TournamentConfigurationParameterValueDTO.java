package com.tournaments.tournaments.dto;

public record TournamentConfigurationParameterValueDTO(
        Integer id,
        Integer tournamentId,
        Integer configurationParameterId,
        String value
) {}
