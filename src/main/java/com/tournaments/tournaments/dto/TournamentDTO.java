package com.tournaments.tournaments.dto;

import java.time.LocalDate;

public record TournamentDTO(
        Integer id,
        Integer tournamentStateId,
        Integer eliminationFormatId,
        String name,
        String description,
        Integer maxParticipantQuantity,
        Integer minParticipantQuantity,
        LocalDate startDate,
        LocalDate endDate
) {}
