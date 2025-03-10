package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.entities.Trainer;
import com.tournaments.tournaments.services.TournamentService;
import com.tournaments.tournaments.services.TrainerService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TournamentRegistrationMapper {

    @Mapping(source = "tournament.id", target = "tournament")
    @Mapping(source = "trainer.id", target = "trainer")
    TournamentRegistrationDTO toDTO(TournamentRegistration entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournament.id", target = "tournament")
    @Mapping(source = "trainer.id", target = "trainer")
    TournamentRegistrationDTO toDTOWithout(TournamentRegistration entity);

    @Mapping(source = "tournament", target = "tournament", qualifiedByName = "idToTournament")
    @Mapping(source = "trainer", target = "trainer", qualifiedByName = "idToTrainer")
    TournamentRegistration toEntity(
            TournamentRegistrationDTO dto,
            @Context TournamentService tournamentService,
            @Context TrainerService trainerService
    );

    @Named("idToTournament")
    default Tournament idToTournament(Integer id, @Context TournamentService tournamentService) {
        return id == null ? null : tournamentService.findTournamentById(id).orElse(null);
    }

    @Named("idToTrainer")
    default Trainer idToTrainer(Integer id, @Context TrainerService trainerService) {
        return id == null ? null : trainerService.findTrainerById(id).orElse(null);
    }
}
