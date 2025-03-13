package com.tournaments.tournaments.dto;

import java.sql.Time;

public record BattleDTO(
        Integer id,
        Integer phase,
        Integer firstParticipant,
        Integer secondParticipant,
        Integer winner,
        Time battleDuration
) {}
