package com.tournaments.tournaments.dto;

import java.time.LocalTime;

public record BattleDTO(
        Integer id,
        Integer phase,
        Integer firsParticipant,
        Integer secondParticipant,
        Integer winner,
        LocalTime battleDuration
) {}
