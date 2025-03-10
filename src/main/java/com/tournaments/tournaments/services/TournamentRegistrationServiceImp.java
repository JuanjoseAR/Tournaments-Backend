package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TournamentRegistrationDTO;
import com.tournaments.tournaments.dto.TournamentRegistrationMapper;
import com.tournaments.tournaments.entities.TournamentRegistration;
import com.tournaments.tournaments.repositories.TournamentRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentRegistrationServiceImp implements TournamentRegistrationService {

    private final TournamentRegistrationRepository tournamentRegistrationRepository;
    private final TournamentRegistrationMapper tournamentRegistrationMapper;
    private final TournamentService tournamentService;
    private final TrainerService trainerService;

    public TournamentRegistrationServiceImp(TournamentRegistrationRepository tournamentRegistrationRepository,
                                            TournamentRegistrationMapper tournamentRegistrationMapper,
                                            TournamentService tournamentService, TrainerService trainerService) {
        this.tournamentRegistrationRepository = tournamentRegistrationRepository;
        this.tournamentRegistrationMapper = tournamentRegistrationMapper;
        this.tournamentService = tournamentService;
        this.trainerService = trainerService;
    }

    @Override
    public Optional<TournamentRegistrationDTO> getTournamentRegistrationById(Integer id) {
        return tournamentRegistrationRepository.findById(id).map(tournamentRegistrationMapper::toDTO);
    }

    @Override
    public Optional<TournamentRegistration> findTournamentRegistrationById(Integer id) {
        return tournamentRegistrationRepository.findById(id);
    }

    @Override
    public List<TournamentRegistrationDTO> getAllTournamentRegistrations() {
        return tournamentRegistrationRepository.findAll().stream()
                .map(dto->tournamentRegistrationMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public TournamentRegistrationDTO createTournamentRegistration(TournamentRegistrationDTO tournamentRegistrationDTO) {
        TournamentRegistration tournamentRegistration = tournamentRegistrationRepository
                .save(tournamentRegistrationMapper.toEntity(tournamentRegistrationDTO, tournamentService, trainerService));
        return tournamentRegistrationMapper.toDTO(tournamentRegistration);
    }

    @Override
    public Optional<TournamentRegistrationDTO> updateTournamentRegistrationById(Integer id, TournamentRegistrationDTO tournamentRegistrationDTO) {
        TournamentRegistration newTournRegistr = tournamentRegistrationMapper.toEntity(tournamentRegistrationDTO, tournamentService, trainerService);
        return tournamentRegistrationRepository.findById(id).map(
                tourRegInBD->{
                    tourRegInBD.setTrainer(newTournRegistr.getTrainer());
                    tourRegInBD.setTournament(newTournRegistr.getTournament());

                    return tournamentRegistrationRepository.save(tourRegInBD);
                }
        ).map(tournamentRegistrationMapper::toDTO);
    }

    @Override
    public void deleteTournamentRegistrationById(Integer id) {
        tournamentRegistrationRepository.deleteById(id);
    }

    @Override
    public void registerTrainerForTournament(Integer tournamentId, Integer trainerId) {
        if (isTrainerRegistered(tournamentId, trainerId)) {
            throw new RuntimeException("Trainer is already registered for this tournament");
        }

        TournamentRegistrationDTO registrationDTO = new TournamentRegistrationDTO(null, tournamentId, trainerId);
        TournamentRegistration registration = tournamentRegistrationMapper.toEntity(registrationDTO, tournamentService, trainerService);
        tournamentRegistrationRepository.save(registration);
    }

    @Override
    public boolean isTrainerRegistered(Integer tournamentId, Integer trainerId) {
        return tournamentRegistrationRepository.existsByTournamentIdAndTrainerId(tournamentId, trainerId);
    }

    @Override
    public List<TournamentRegistrationDTO> getRegistrationsByTournamentId(Integer tournamentId) {
        return tournamentRegistrationRepository.findByTournamentId(tournamentId).stream()
                .map(tournamentRegistrationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
