package com.tournaments.tournaments.dto;

import java.time.LocalDate;

public record TournamentDTO(
        Integer id,
        Integer tournamentState,
        String name,
        String description,
        Integer maxParticipantQuantity,
        Integer minParticipantQuantity,
        LocalDate startDate,
        LocalDate endDate
) {}
