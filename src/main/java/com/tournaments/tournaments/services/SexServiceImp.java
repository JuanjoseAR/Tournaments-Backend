package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Sex;
import com.tournaments.tournaments.repositories.SexRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SexServiceImp implements SexService{

    private SexRepository sexRepository;

    public SexServiceImp(SexRepository sexRepository){
        this.sexRepository = sexRepository;
    }

    @Override
    public Optional<Sex> getSexById(Integer id) {
        return sexRepository.findById(id);
    }

    @Override
    public List<Sex> getAllSexs() {
        return sexRepository.findAll();
    }

    @Override
    public Sex createSex(Sex sex) {
        return sexRepository.save(sex);
    }

    @Override
    public Optional<Sex> updateSexById(Integer id, Sex sex) {
        return sexRepository.findById(id).map(
                sexInBD->{
                    sexInBD.setName(sex.getName());
                    sexInBD.setDescription(sex.getDescription());
                    return sexRepository.save(sexInBD);
                }
        );
    }

    @Override
    public void deleteSexById(Integer id) {
        sexRepository.deleteById(id);
    }
}
