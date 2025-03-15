package com.tournaments.tournaments.dto;

import java.time.LocalDate;

public record PhaseDTO(
        Integer id,
        Integer tournament,
        String name,
        String description,
        Integer consecutiveNumberWithinTournament,
        LocalDate startDate,
        LocalDate endDate
) {}
