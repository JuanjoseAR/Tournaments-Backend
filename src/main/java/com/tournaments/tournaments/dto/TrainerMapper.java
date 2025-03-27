package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Team;
import com.tournaments.tournaments.entities.Trainer;
import com.tournaments.tournaments.services.TeamService;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(source = "team.id", target = "team")
    TrainerDTO toDTO(Trainer trainer);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "team.id", target = "team")
    TrainerDTO toDTOWithout(Trainer trainer);

    @Mapping(source = "team", target = "team", qualifiedByName = "idToTeam")
    Trainer toEntity(
            TrainerDTO dto,
            @Context TeamService teamService
    );

    @Named("idToTeam")
    default Team idToTeam(String id, @Context TeamService teamService) {
        return id == null ? null : teamService.getTeamById(id).orElse(null);
    }
}

