package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.EliminationFormat;
import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.services.EliminationFormatService;
import com.tournaments.tournaments.services.TournamentService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface PhaseMapper {

    @Mapping(source = "tournament.id", target = "tournamentId")
    @Mapping(source = "eliminationFormat.id", target = "eliminationFormatId")
    @Mapping(source = "consecutiveNumberWithinTournament", target = "consecutiveNumberWithinTournament")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    PhaseDTO toDTO(Phase phase);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournament.id", target = "tournamentId")
    @Mapping(source = "eliminationFormat.id", target = "eliminationFormatId")
    @Mapping(source = "consecutiveNumberWithinTournament", target = "consecutiveNumberWithinTournament")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    PhaseDTO toDTOWithoutId(Phase phase);

    @Mapping(source = "tournamentId", target = "tournament", qualifiedByName = "idToTournament")
    @Mapping(source = "eliminationFormatId", target = "eliminationFormat", qualifiedByName = "idToEliminationFormat")
    @Mapping(source = "consecutiveNumberWithinTournament", target = "consecutiveNumberWithinTournament")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    Phase toEntity(
            PhaseDTO dto,
            @Context TournamentService tournamentService,
            @Context EliminationFormatService eliminationFormatService
    );

    @Named("idToTournament")
    default Tournament idToTournament(Integer id, @Context TournamentService tournamentService) {
        return id == null ? null : tournamentService.getTournamentById(id).orElse(null);
    }

    @Named("idToEliminationFormat")
    default EliminationFormat idToEliminationFormat(Integer id, @Context EliminationFormatService eliminationFormatService) {
        return id == null ? null : eliminationFormatService.getEliminationFormatById(id).orElse(null);
    }
}
