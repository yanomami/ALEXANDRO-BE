package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Page<Country> findAllPageable(Pageable pageable);
    Country findById(Integer id);
    Country create(Country country);
    Country update(Country country);
    void delete(Integer id);
}
