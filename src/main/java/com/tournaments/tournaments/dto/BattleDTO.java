package com.tournaments.tournaments.dto;

import java.time.LocalTime;

public record BattleDTO(
        Integer id,
        Integer phaseId,
        Integer winnerId,
        Integer loserId,
        LocalTime battleduration
) {}
