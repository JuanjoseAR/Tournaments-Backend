package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.ConfigurationParameter;
import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;
import com.tournaments.tournaments.entities.TournamentState;
import com.tournaments.tournaments.services.ConfigurationParameterService;
import com.tournaments.tournaments.services.TournamentStateService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TournamentConfigurationParameterValueMapper {

    @Mapping(source = "tournament.id", target = "tournament")
    @Mapping(source = "configurationParameter.id", target = "configurationParameter")
    TournamentConfigurationParameterValueDTO toDTO(TournamentConfigurationParameterValue entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "tournament.id", target = "tournament")
    @Mapping(source = "configurationParameter.id", target = "configurationParameter")
    TournamentConfigurationParameterValueDTO toDTOWithout(TournamentConfigurationParameterValue entity);

    @Mapping(source = "tournament", target = "tournament", qualifiedByName = "idToTournamentState")
    @Mapping(source = "configurationParameter", target = "configurationParameter", qualifiedByName = "idToConfigurationParameter")
    TournamentConfigurationParameterValue toEntity(
            TournamentConfigurationParameterValueDTO dto,
            @Context TournamentStateService tournamentStateService,
            @Context ConfigurationParameterService configurationParameterService
    );

    @Named("idToTournamentState")
    default TournamentState idToTournamentState(Integer id, @Context TournamentStateService tournamentStateService) {
        return id == null ? null : tournamentStateService.getTournamentStateById(id).orElse(null);
    }

    @Named("idToConfigurationParameter")
    default ConfigurationParameter idToConfigurationParameter(Integer id, @Context ConfigurationParameterService configurationParameterService) {
        return id == null ? null : configurationParameterService.getConfigurationParameterById(id).orElse(null);
    }
}
