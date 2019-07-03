package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.CountryEntity;

import java.util.List;

public interface CountryService {
    List<CountryEntity> findAll();
    CountryEntity findById(Integer id);
    CountryEntity create(CountryEntity country);
    CountryEntity update(CountryEntity country);
    void delete(Integer id);
}
