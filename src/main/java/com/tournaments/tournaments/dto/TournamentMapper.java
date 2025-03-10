package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.EliminationFormat;
import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.entities.TournamentState;
import com.tournaments.tournaments.services.EliminationFormatService;
import com.tournaments.tournaments.services.TournamentStateService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    @Mapping(source = "tournamentState.id", target = "tournamentState")
    @Mapping(source = "eliminationFormat.id", target = "eliminationFormat")
    TournamentDTO toDTO(Tournament tournament);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournamentState.id", target = "tournamentState")
    @Mapping(source = "eliminationFormat.id", target = "eliminationFormat")
    TournamentDTO toDTOWithout(Tournament tournament);

    @Mapping(source = "tournamentState", target = "tournamentState", qualifiedByName = "idToTournamentState")
    @Mapping(source = "eliminationFormat", target = "eliminationFormat", qualifiedByName = "idToEliminationFormat")
    Tournament toEntity(
            TournamentDTO dto,
            @Context TournamentStateService tournamentStateService,
            @Context EliminationFormatService eliminationFormatService
    );

    @Named("idToTournamentState")
    default TournamentState idToTournamentState(Integer id, @Context TournamentStateService tournamentStateService) {
        return id == null ? null : tournamentStateService.getTournamentStateById(id).orElse(null);
    }

    @Named("idToEliminationFormat")
    default EliminationFormat idToEliminationFormat(Integer id, @Context EliminationFormatService eliminationFormatService) {
        return id == null ? null : eliminationFormatService.getEliminationFormatById(id).orElse(null);
    }
}
