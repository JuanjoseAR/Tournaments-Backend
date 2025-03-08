package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Trainer;
import com.tournaments.tournaments.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImp implements TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerServiceImp(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Optional<Trainer> getTrainerById(Integer id) {
        return trainerRepository.findById(id);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Optional<Trainer> updateTrainerById(Integer id, Trainer trainer) {
        return trainerRepository.findById(id).map(
                trainerInBD->{
                    trainerInBD.setName(trainer.getName());
                    trainerInBD.setSexid(trainer.getSexid());
                    trainerInBD.setTeamid(trainer.getTeamid());

                    return trainerRepository.save(trainerInBD);
                }
        );
    }

    @Override
    public void deleteTrainerById(Integer id) {
        trainerRepository.deleteById(id);
    }
}
