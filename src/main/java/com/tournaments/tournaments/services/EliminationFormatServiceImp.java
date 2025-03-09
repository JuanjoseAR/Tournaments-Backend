package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.EliminationFormat;
import com.tournaments.tournaments.repositories.EliminationFormatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EliminationFormatServiceImp implements EliminationFormatService {

    private final EliminationFormatRepository eliminationFormatRepository;

    public EliminationFormatServiceImp(EliminationFormatRepository eliminationFormatRepository) {
        this.eliminationFormatRepository = eliminationFormatRepository;
    }

    @Override
    public Optional<EliminationFormat> getEliminationFormatById(Integer id) {
        return eliminationFormatRepository.findById(id);
    }

    @Override
    public Optional<EliminationFormat> findEliminationFormatById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<EliminationFormat> getAllEliminationFormats() {
        return eliminationFormatRepository.findAll();
    }

    @Override
    public EliminationFormat createEliminationFormat(EliminationFormat eliminationFormat) {
        return eliminationFormatRepository.save(eliminationFormat);
    }

    @Override
    public Optional<EliminationFormat> updateEliminationFormatById(Integer id, EliminationFormat eliminationFormat) {
        return eliminationFormatRepository.findById(id).map(
                elimiFormat->{
                    elimiFormat.setName(eliminationFormat.getName());
                    elimiFormat.setDescription(eliminationFormat.getDescription());
                    return eliminationFormatRepository.save(elimiFormat);
                }
        );
    }

    @Override
    public void deleteEliminationFormatById(Integer id) {
        eliminationFormatRepository.deleteById(id);
    }
}
