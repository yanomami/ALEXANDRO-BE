package com.jle.alexandro.dao;

import com.jle.alexandro.models.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "results", path = "countries")
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @RestResource(path = "/byDescription") // Accessible via /alexandro/countries/search/byDescription?...
    public Page<Country> findByDescriptionContains(@Param("key") String key, Pageable pageable);
}
