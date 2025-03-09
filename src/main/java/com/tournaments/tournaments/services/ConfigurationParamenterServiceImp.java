package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.ConfigurationParameter;
import com.tournaments.tournaments.repositories.ConfigurationParameterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationParamenterServiceImp implements ConfigurationParameterService {

    private final ConfigurationParameterRepository parameterRepository;

    public ConfigurationParamenterServiceImp(ConfigurationParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public Optional<ConfigurationParameter> getConfigurationParameterById(Integer id) {
        return parameterRepository.findById(id);
    }

    @Override
    public List<ConfigurationParameter> getAllConfigurationParameters() {
        return parameterRepository.findAll();
    }

    @Override
    public ConfigurationParameter createConfigurationParameter(ConfigurationParameter configurationParameter) {
        return parameterRepository.save(configurationParameter);
    }

    @Override
    public Optional<ConfigurationParameter> updateConfigurationParameterById(Integer id, ConfigurationParameter configurationParameter) {
        return parameterRepository.findById(id).map(
                configParamenter -> {
                    configParamenter.setName(configurationParameter.getName());
                    configParamenter.setDescription(configurationParameter.getDescription());
                    configParamenter.setDataType(configurationParameter.getDataType());


                    return parameterRepository.save(configParamenter);
                }
        );
    }

    @Override
    public void deleteConfigurationParameterById(Integer id) {
        parameterRepository.deleteById(id);
    }
}
