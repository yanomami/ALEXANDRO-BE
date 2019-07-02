package com.jle.alexandro.dao;

import com.jle.alexandro.model.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "result", path = "countries")
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
}
