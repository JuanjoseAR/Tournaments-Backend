package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Sex;

import java.util.List;
import java.util.Optional;

public interface SexService {
    Optional<Sex> getSexById(Integer id);
    List<Sex> getAllSexs();
    Sex createSex(Sex sex);
    Optional<Sex> updateSexById(Integer id, Sex sex);
    void deleteSexById(Integer id);
}
