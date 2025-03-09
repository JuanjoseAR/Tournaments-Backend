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
    private final EliminationFormatService eliminationFormatService;


    public TournamentServiceImp(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper
            ,TournamentStateService tournamentStateService, EliminationFormatService eliminationFormatService) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
        this.tournamentStateService = tournamentStateService;
        this.eliminationFormatService = eliminationFormatService;
    }


    @Override
    public Optional<TournamentDTO> getTournamentById(Integer id) {
        return tournamentRepository.findById(id).map(tournamentMapper::toDTO);
    }

    @Override
    public List<TournamentDTO> getAllTournaments() {
        return tournamentRepository.findAll().stream()
                .map(dto->tournamentMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public TournamentDTO createTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentRepository.save(tournamentMapper.toEntity(tournamentDTO, tournamentStateService, eliminationFormatService));
        return tournamentMapper.toDTO(tournament);
    }

    @Override
    public Optional<TournamentDTO> updateTournamentById(Integer id, TournamentDTO tournamentDTO) {
        Tournament newTournament = tournamentMapper.toEntity(tournamentDTO, tournamentStateService, eliminationFormatService);
        return tournamentRepository.findById(id).map(
                tournamentInBD->{
                    tournamentInBD.setName(newTournament.getName());
                    tournamentInBD.setDescription(newTournament.getDescription());
                    tournamentInBD.setStartdate(newTournament.getStartdate());
                    tournamentInBD.setEnddate(newTournament.getEnddate());
                    tournamentInBD.setEliminationformatid(newTournament.getEliminationformatid());
                    tournamentInBD.setMinparticipantquantity(newTournament.getMinparticipantquantity());
                    tournamentInBD.setMaxparticipantquantity(newTournament.getMaxparticipantquantity());
                    tournamentInBD.setTournamentstateid(newTournament.getTournamentstateid());


                    return tournamentRepository.save(tournamentInBD);
                }
        ).map(tournamentMapper::toDTO);
    }

    @Override
    public void deleteTournamentById(Integer id) {
        tournamentRepository.deleteById(id);
    }
}
