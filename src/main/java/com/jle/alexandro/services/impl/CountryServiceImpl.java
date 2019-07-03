package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.CountryRepository;
import com.jle.alexandro.models.entities.CountryEntity;
import com.jle.alexandro.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<CountryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CountryEntity findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public CountryEntity update(CountryEntity country) {
        return repository.save(country);
    }

    @Override
    public CountryEntity create(CountryEntity country) {
        return repository.save(country);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
