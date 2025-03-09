package com.tournaments.tournaments.dto;


import com.tournaments.tournaments.entities.Battle;
import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.entities.Trainer;
import com.tournaments.tournaments.services.PhaseService;
import com.tournaments.tournaments.services.TrainerService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface BattleMapper {

    @Mapping(source = "phase.id", target = "phaseId")
    @Mapping(source = "winner.id", target = "winnerId")
    @Mapping(source = "loser.id", target = "loserId")
    @Mapping(source = "battleDuration", target = "battleDuration")
    BattleDTO toDTO(Battle battle);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "phase.id", target = "phaseId")
    @Mapping(source = "winner.id", target = "winnerId")
    @Mapping(source = "loser.id", target = "loserId")
    @Mapping(source = "battleDuration", target = "battleDuration")
    BattleDTO toDTOWithoutId(Battle battle);

    @Mapping(source = "phaseId", target = "phase", qualifiedByName = "idToPhase")
    @Mapping(source = "winnerId", target = "winner", qualifiedByName = "idToTrainer")
    @Mapping(source = "loserId", target = "loser", qualifiedByName = "idToTrainer")
    @Mapping(source = "battleDuration", target = "battleDuration")
    Battle toEntity(
            BattleDTO dto,
            @Context PhaseService phaseService,
            @Context TrainerService trainerService
    );

    @Named("idToPhase")
    default Phase idToPhase(Integer id, @Context PhaseService phaseService) {
        return id == null ? null : phaseService.getPhaseById(id).orElse(null);
    }

    @Named("idToTrainer")
    default Trainer idToTrainer(Integer id, @Context TrainerService trainerService) {
        return id == null ? null : trainerService.getTrainerById(id).orElse(null);
    }
}
