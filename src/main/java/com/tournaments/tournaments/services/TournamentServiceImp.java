package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.repositories.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentServiceImp implements TournamentService {

    private TournamentRepository tournamentRepository;

    public TournamentServiceImp(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }


    @Override
    public Optional<Tournament> getTournamentById(Integer id) {
        return tournamentRepository.findById(id);
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public Optional<Tournament> updateTournamentById(Integer id, Tournament tournament) {
        return tournamentRepository.findById(id).map(
                tournamentInBD->{
                    tournamentInBD.setName(tournament.getName());
                    tournamentInBD.setDescription(tournament.getDescription());
                    tournamentInBD.setStartdate(tournament.getStartdate());
                    tournamentInBD.setEnddate(tournament.getEnddate());
                    tournamentInBD.setEliminationformatid(tournament.getEliminationformatid());
                    tournamentInBD.setMinparticipantquantity(tournament.getMinparticipantquantity());
                    tournamentInBD.setMaxparticipantquantity(tournament.getMaxparticipantquantity());
                    tournamentInBD.setTournamentstateid(tournament.getTournamentstateid());


                    return tournamentRepository.save(tournamentInBD);
                }
        );
    }

    @Override
    public void deleteTournamentById(Integer id) {
        tournamentRepository.deleteById(id);
    }
}
