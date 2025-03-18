package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.entities.TournamentState;
import com.tournaments.tournaments.services.TournamentStateService;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    @Mapping(source = "tournamentState.name", target = "tournamentState")
    TournamentDTO toDTO(Tournament tournament);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournamentState.id", target = "tournamentState")
    TournamentDTO toDTOWithout(Tournament tournament);

    @Mapping(source = "tournamentState", target = "tournamentState", qualifiedByName = "nameToTournamentState")
    Tournament toEntity(
            TournamentDTO dto,
            @Context TournamentStateService tournamentStateService
    );

    @Named("nameToTournamentState")
    default TournamentState idToTournamentState(String name, @Context TournamentStateService tournamentStateService) {
        return name == null ? null : tournamentStateService.getTournamentStateByName(name);
    }
}