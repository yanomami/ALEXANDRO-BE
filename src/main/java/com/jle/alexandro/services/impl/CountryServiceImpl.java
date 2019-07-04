package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.CountryRepository;
import com.jle.alexandro.models.entities.Country;
import com.jle.alexandro.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Country> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Country findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Country update(Country country) {
        return repository.save(country);
    }

    @Override
    public Country create(Country country) {
        return repository.save(country);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
