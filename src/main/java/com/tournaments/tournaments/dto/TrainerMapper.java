package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Sex;
import com.tournaments.tournaments.entities.Team;
import com.tournaments.tournaments.entities.Trainer;
import com.tournaments.tournaments.services.SexService;
import com.tournaments.tournaments.services.TeamService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(source = "team.id", target = "team")
    @Mapping(source = "sex.id", target = "sex")
    TrainerDTO toDTO(Trainer trainer);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "team.id", target = "team")
    @Mapping(source = "sex.id", target = "sex")
    TrainerDTO toDTOWithout(Trainer trainer);

    @Mapping(source = "team", target = "team", qualifiedByName = "idToTeam")
    @Mapping(source = "sex", target = "sex", qualifiedByName = "idToSex")
    Trainer toEntity(
            TrainerDTO dto,
            @Context TeamService teamService,
            @Context SexService sexService
    );

    @Named("idToTeam")
    default Team idToTeam(Integer id, @Context TeamService teamService) {
        return id == null ? null : teamService.getTeamById(id).orElse(null);
    }

    @Named("idToSex")
    default Sex idToSex(Integer id, @Context SexService sexService) {
        return id == null ? null : sexService.getSexById(id).orElse(null);
    }
}

