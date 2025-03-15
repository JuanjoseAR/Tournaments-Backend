package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.entities.TournamentState;
import com.tournaments.tournaments.services.TournamentStateService;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    @Mapping(source = "tournamentState.id", target = "tournamentState")
    TournamentDTO toDTO(Tournament tournament);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournamentState.id", target = "tournamentState")
    TournamentDTO toDTOWithout(Tournament tournament);

    @Mapping(source = "tournamentState", target = "tournamentState", qualifiedByName = "idToTournamentState")
    Tournament toEntity(
            TournamentDTO dto,
            @Context TournamentStateService tournamentStateService
    );

    @Named("idToTournamentState")
    default TournamentState idToTournamentState(Integer id, @Context TournamentStateService tournamentStateService) {
        return id == null ? null : tournamentStateService.getTournamentStateById(id).orElse(null);
    }
}