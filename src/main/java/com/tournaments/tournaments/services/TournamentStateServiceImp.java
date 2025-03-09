package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TournamentState;
import com.tournaments.tournaments.repositories.TournamentStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentStateServiceImp implements TournamentStateService {

    private final TournamentStateRepository tournamentStateRepository;

    public TournamentStateServiceImp(TournamentStateRepository tournamentStateRepository) {
        this.tournamentStateRepository = tournamentStateRepository;
    }

    @Override
    public Optional<TournamentState> getTournamentStateById(Integer id) {
        return tournamentStateRepository.findById(id);
    }

    @Override
    public List<TournamentState> getAllTournamentStates() {
        return tournamentStateRepository.findAll();
    }

    @Override
    public TournamentState createTournamentState(TournamentState tournamentState) {
        return tournamentStateRepository.save(tournamentState);
    }

    @Override
    public Optional<TournamentState> updateTournamentStateById(Integer id, TournamentState tournamentState) {
        return tournamentStateRepository.findById(id).map(
                tournStateInBD->{
                    tournStateInBD.setName(tournamentState.getName());
                    tournStateInBD.setDescription(tournamentState.getDescription());

                    return tournamentStateRepository.save(tournStateInBD);
                }
        );
    }

    @Override
    public void deleteTournamentStateById(Integer id) {
        tournamentStateRepository.deleteById(id);
    }
}
