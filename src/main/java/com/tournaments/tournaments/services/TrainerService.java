package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    Optional<Trainer> getTrainerById(Integer id);
    List<Trainer> getAllTrainers();
    Optional<Trainer> createTrainer(Trainer trainer);
    Optional<Trainer> updateTrainerById(Integer id, Trainer trainer);
    void deleteTrainerById(Integer id);
}
