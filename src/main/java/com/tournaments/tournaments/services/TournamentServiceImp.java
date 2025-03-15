package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentDTO;
import com.tournaments.tournaments.dto.TournamentMapper;
import com.tournaments.tournaments.entities.Tournament;
import com.tournaments.tournaments.repositories.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentServiceImp implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;
    private final TournamentStateService tournamentStateService;

    public TournamentServiceImp(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper
            , TournamentStateService tournamentStateService) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
        this.tournamentStateService = tournamentStateService;
    }


    @Override
    public Optional<TournamentDTO> getTournamentById(Integer id) {
        return tournamentRepository.findById(id).map(tournamentMapper::toDTO);
    }

    @Override
    public Optional<Tournament> findTournamentById(Integer id) {
        return tournamentRepository.findById(id);
    }

    @Override
    public List<TournamentDTO> getAllTournaments() {
        return tournamentRepository.findAll().stream()
                .map(tournamentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public TournamentDTO createTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentRepository.save(tournamentMapper.toEntity(tournamentDTO, tournamentStateService));
        return tournamentMapper.toDTO(tournament);
    }

    @Override
    public Optional<TournamentDTO> updateTournamentById(Integer id, TournamentDTO tournamentDTO) {
        Tournament newTournament = tournamentMapper.toEntity(tournamentDTO, tournamentStateService);
        return tournamentRepository.findById(id).map(
                tournamentInBD->{
                    tournamentInBD.setName(newTournament.getName());
                    tournamentInBD.setDescription(newTournament.getDescription());
                    tournamentInBD.setStartDate(newTournament.getStartDate());
                    tournamentInBD.setEndDate(newTournament.getEndDate());
                    tournamentInBD.setMinParticipantQuantity(newTournament.getMinParticipantQuantity());
                    tournamentInBD.setMaxParticipantQuantity(newTournament.getMaxParticipantQuantity());
                    tournamentInBD.setTournamentState(newTournament.getTournamentState());


                    return tournamentRepository.save(tournamentInBD);
                }
        ).map(tournamentMapper::toDTO);
    }

    @Override
    public void deleteTournamentById(Integer id) {
        tournamentRepository.deleteById(id);
    }
}
