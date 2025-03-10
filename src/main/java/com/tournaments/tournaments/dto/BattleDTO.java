package com.tournaments.tournaments.dto;

import java.time.LocalTime;

public record BattleDTO(
        Integer id,
        Integer phase,
        Integer firstParticipant,
        Integer secondParticipant,
        Integer winner,
        LocalTime battleDuration
) {}
