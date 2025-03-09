package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentConfigurationParameterValueDTO;
import com.tournaments.tournaments.dto.TournamentConfigurationParameterValueMapper;
import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;
import com.tournaments.tournaments.repositories.TournamentConfigurationParameterValueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentConfigurationParameterValueServiceImp implements TournamentConfigurationParameterValueService {

    private final TournamentConfigurationParameterValueRepository tournamentConfigurationParameterValueRepository;
    private final TournamentConfigurationParameterValueMapper tournamentConfigurationParameterValueMapper;


    public TournamentConfigurationParameterValueServiceImp(TournamentConfigurationParameterValueRepository tournamentConfigurationParameterValueRepository,
                                                           TournamentConfigurationParameterValueMapper tournamentConfigurationParameterValueMapper) {
        this.tournamentConfigurationParameterValueRepository = tournamentConfigurationParameterValueRepository;
        this.tournamentConfigurationParameterValueMapper = tournamentConfigurationParameterValueMapper;
    }

    @Override
    public Optional<TournamentConfigurationParameterValueDTO> getTournamentConfigurationParameterValueById(Integer id) {
        return tournamentConfigurationParameterValueRepository.findById(id).map(tournamentConfigurationParameterValueMapper::toDTO);
    }

    @Override
    public List<TournamentConfigurationParameterValueDTO> getAllTournamentConfigurationParameterValues() {
        return tournamentConfigurationParameterValueRepository.findAll().stream()
                .map(dto->tournamentConfigurationParameterValueMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public TournamentConfigurationParameterValueDTO createTournamentConfigurationParameterValue(TournamentConfigurationParameterValueDTO tournamentConfigurationParameterValueDTO) {
        TournamentConfigurationParameterValue newTourConfigParaValue = tournamentConfigurationParameterValueRepository
                .save(tournamentConfigurationParameterValueMapper
                        .toEntity(tournamentConfigurationParameterValueDTO));
        return tournamentConfigurationParameterValueMapper.toDTO(newTourConfigParaValue);
    }

    @Override
    public Optional<TournamentConfigurationParameterValueDTO> updateTournamentConfigurationParameterValueById(Integer id,
                                                                                                              TournamentConfigurationParameterValueDTO tournamentConfigurationParameterValueDTO) {
        TournamentConfigurationParameterValue newTournConfigParValue = tournamentConfigurationParameterValueMapper.toEntity(tournamentConfigurationParameterValueDTO);
        return tournamentConfigurationParameterValueRepository.findById(id).map(
                tourConfigParaValueInBD->{
                    tourConfigParaValueInBD.setValue(newTournConfigParValue.getValue());
                    tourConfigParaValueInBD.setTournamentid(newTournConfigParValue.getTournamentid());
                    tourConfigParaValueInBD.setConfigurationparameterid(newTournConfigParValue.getConfigurationparameterid());


                    return tournamentConfigurationParameterValueRepository.save(tourConfigParaValueInBD);

                }
        ).map(tournamentConfigurationParameterValueMapper::toDTO);
    }

    @Override
    public void deleteTournamentConfigurationParameterValueById(Integer id) {
        tournamentConfigurationParameterValueRepository.deleteById(id);
    }
}
