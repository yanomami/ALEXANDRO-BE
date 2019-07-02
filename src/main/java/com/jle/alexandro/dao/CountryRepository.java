package com.jle.alexandro.dao;

import com.jle.alexandro.models.entities.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "results", path = "countries")
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
    @RestResource(path = "/ByDescriptionPage")
    public List<CountryEntity> findByDescriptionContains(@Param("mc") String description);
}
