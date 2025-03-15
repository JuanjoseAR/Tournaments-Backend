package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.services.TournamentService;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PhaseMapper {

    @Mapping(source = "tournament.id", target = "tournament")
    @Mapping(source = "consecutiveNumberWithinTournament", target = "consecutiveNumberWithinTournament")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    PhaseDTO toDTO(Phase phase);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournament.id", target = "tournament")
    @Mapping(source = "consecutiveNumberWithinTournament", target = "consecutiveNumberWithinTournament")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    PhaseDTO toDTOWithout(Phase phase);

    @Mapping(source = "tournament", target = "tournament", qualifiedByName = "idToTournament")
    @Mapping(source = "consecutiveNumberWithinTournament", target = "consecutiveNumberWithinTournament")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    Phase toEntity(
            PhaseDTO dto,
            @Context TournamentService tournamentService
    );

    @Named("idToTournament")
    default Tournament idToTournament(Integer id, @Context TournamentService tournamentService) {
        return id == null ? null : tournamentService.findTournamentById(id).orElse(null);
    }
}
