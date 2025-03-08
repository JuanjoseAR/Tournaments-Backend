package com.tournaments.tournaments.dto;

import java.time.LocalDate;

public record PhaseDTO(
        Integer id,
        Integer tournamentId,
        Integer eliminationFormatId,
        String name,
        String description,
        Integer consecutivenumberwithintournament,
        LocalDate startdate,
        LocalDate enddate
) {}
