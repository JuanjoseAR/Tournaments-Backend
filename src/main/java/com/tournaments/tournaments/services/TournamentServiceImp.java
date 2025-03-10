package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentDTO;
import com.tournaments.tournaments.dto.TournamentMapper;
import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
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
    private final TournamentRegistrationService tournamentRegistrationService;


    public TournamentServiceImp(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper
            , TournamentStateService tournamentStateService, EliminationFormatService eliminationFormatService, TournamentRegistrationService tournamentRegistrationService) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
        this.tournamentStateService = tournamentStateService;
        this.eliminationFormatService = eliminationFormatService;
        this.tournamentRegistrationService = tournamentRegistrationService;
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
                    tournamentInBD.setStartDate(newTournament.getStartDate());
                    tournamentInBD.setEndDate(newTournament.getEndDate());
                    tournamentInBD.setEliminationFormat(newTournament.getEliminationFormat());
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

    @Override
    public void registerTrainerForTournament(Integer tournamentId, Integer trainerId) {
        tournamentRegistrationService.registerTrainerForTournament(tournamentId, trainerId);
    }

    @Override
    public boolean isTrainerRegistered(Integer tournamentId, Integer trainerId) {
        return tournamentRegistrationService.isTrainerRegistered(tournamentId, trainerId);
    }

    @Override
    public List<TournamentRegistrationDTO> getRegistrationsByTournamentId(Integer tournamentId) {
        return tournamentRegistrationService.getRegistrationsByTournamentId(tournamentId);
    }
}
