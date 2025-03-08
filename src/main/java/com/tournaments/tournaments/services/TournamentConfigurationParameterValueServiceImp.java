package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;
import com.tournaments.tournaments.repositories.TournamentConfigurationParameterValueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentConfigurationParameterValueServiceImp implements TournamentConfigurationParameterValueService {

    private TournamentConfigurationParameterValueRepository tournamentConfigurationParameterValueRepository;

    public TournamentConfigurationParameterValueServiceImp(TournamentConfigurationParameterValueRepository tournamentConfigurationParameterValueRepository) {
        this.tournamentConfigurationParameterValueRepository = tournamentConfigurationParameterValueRepository;
    }

    @Override
    public Optional<TournamentConfigurationParameterValue> getTournamentConfigurationParameterValueById(Integer id) {
        return tournamentConfigurationParameterValueRepository.findById(id);
    }

    @Override
    public List<TournamentConfigurationParameterValue> getAllTournamentConfigurationParameterValues() {
        return tournamentConfigurationParameterValueRepository.findAll();
    }

    @Override
    public TournamentConfigurationParameterValue createTournamentConfigurationParameterValue(TournamentConfigurationParameterValue tournamentConfigurationParameterValue) {
        return tournamentConfigurationParameterValueRepository.save(tournamentConfigurationParameterValue);
    }

    @Override
    public Optional<TournamentConfigurationParameterValue> updateTournamentConfigurationParameterValueById(Integer id, TournamentConfigurationParameterValue tournamentConfigurationParameterValue) {
        return tournamentConfigurationParameterValueRepository.findById(id).map(
                tourConfigParaValueInBD->{
                    tourConfigParaValueInBD.setValue(tournamentConfigurationParameterValue.getValue());
                    tourConfigParaValueInBD.setTournamentid(tournamentConfigurationParameterValue.getTournamentid());
                    tourConfigParaValueInBD.setConfigurationparameterid(tournamentConfigurationParameterValue.getConfigurationparameterid());


                    return tournamentConfigurationParameterValueRepository.save(tourConfigParaValueInBD);

                }
        );
    }

    @Override
    public void deleteTournamentConfigurationParameterValueById(Integer id) {
        tournamentConfigurationParameterValueRepository.deleteById(id);
    }
}
