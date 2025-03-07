package com.tournaments.tournaments.dto;

public record ConfigurationParameterDTO(
        Integer id,
        String name,
        String dataType,
        String description,
        Boolean isMandatory,
        Boolean isUnique
) {}
