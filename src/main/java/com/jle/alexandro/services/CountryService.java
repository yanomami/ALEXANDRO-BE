package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {
    List<CountryEntity> findAll();
    Page<CountryEntity> findAllPageable(Pageable pageable);
    CountryEntity findById(Integer id);
    CountryEntity create(CountryEntity country);
    CountryEntity update(CountryEntity country);
    void delete(Integer id);
}
