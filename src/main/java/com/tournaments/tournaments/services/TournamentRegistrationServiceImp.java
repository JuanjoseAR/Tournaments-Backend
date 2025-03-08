package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.repositories.TournamentRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentRegistrationServiceImp implements TournamentRegistrationService {

    private TournamentRegistrationRepository tournamentRegistrationRepository;

    public TournamentRegistrationServiceImp(TournamentRegistrationRepository tournamentRegistrationRepository) {
        this.tournamentRegistrationRepository = tournamentRegistrationRepository;
    }

    @Override
    public Optional<TournamentRegistration> getTournamentRegistrationById(Integer id) {
        return tournamentRegistrationRepository.findById(id);
    }

    @Override
    public List<TournamentRegistration> getAllTournamentRegistrations() {
        return tournamentRegistrationRepository.findAll();
    }

    @Override
    public TournamentRegistration createTournamentRegistration(TournamentRegistration tournamentRegistration) {
        return tournamentRegistrationRepository.save(tournamentRegistration);
    }

    @Override
    public Optional<TournamentRegistration> updateTournamentRegistrationById(Integer id, TournamentRegistration tournamentRegistration) {
        return tournamentRegistrationRepository.findById(id).map(
                tourRegInBD->{
                    tourRegInBD.setTrainerid(tournamentRegistration.getTrainerid());
                    tourRegInBD.setTournamentid(tournamentRegistration.getTournamentid());

                    return tournamentRegistrationRepository.save(tourRegInBD);
                }
        );
    }

    @Override
    public void deleteTournamentRegistrationById(Integer id) {
        tournamentRegistrationRepository.deleteById(id);
    }
}
