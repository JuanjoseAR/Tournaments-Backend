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

    @Mapping(source = "phase.id", target = "phase")
    @Mapping(source = "winner.id", target = "winner")
    @Mapping(source = "loser.id", target = "loser")
    @Mapping(source = "battleDuration", target = "battleDuration")
    BattleDTO toDTO(Battle battle);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "phase.id", target = "phase")
    @Mapping(source = "winner.id", target = "winner")
    @Mapping(source = "loser.id", target = "loser")
    @Mapping(source = "battleDuration", target = "battleDuration")
    BattleDTO toDTOWithout(Battle battle);

    @Mapping(source = "phase", target = "phase", qualifiedByName = "idToPhase")
    @Mapping(source = "winner", target = "winner", qualifiedByName = "idToTrainer")
    @Mapping(source = "loser", target = "loser", qualifiedByName = "idToTrainer")
    @Mapping(source = "battleDuration", target = "battleDuration")
    Battle toEntity(
            BattleDTO dto,
            @Context PhaseService phaseService,
            @Context TrainerService trainerService
    );

    @Named("idToPhase")
    default Phase idToPhase(Integer id, @Context PhaseService phaseService) {
        return id == null ? null : phaseService.findPhaseById(id).orElse(null);
    }

    @Named("idToTrainer")
    default Trainer idToTrainer(Integer id, @Context TrainerService trainerService) {
        return id == null ? null : trainerService.findTrainerById(id).orElse(null);
    }
}
