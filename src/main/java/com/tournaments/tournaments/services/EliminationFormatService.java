package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.ConfigurationParameter;
import com.tournaments.tournaments.entities.EliminationFormat;

import java.util.List;
import java.util.Optional;

public interface EliminationFormatService {
    Optional<EliminationFormat> getEliminationFormatById(Integer id);
    List<EliminationFormat> getAllEliminationFormats();
    EliminationFormat createEliminationFormat(EliminationFormat eliminationFormat);
    Optional<EliminationFormat> updateEliminationFormatById(Integer id, EliminationFormat eliminationFormat);
    void deleteEliminationFormatById(Integer id);

}
