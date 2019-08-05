package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.CountryRepository;
import com.jle.alexandro.models.entities.Country;
import com.jle.alexandro.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Country> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Country update(Country resource) {
        return repository.save(resource);
    }

    @Override
    public Country create(Country resource) {
        return repository.save(resource);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
