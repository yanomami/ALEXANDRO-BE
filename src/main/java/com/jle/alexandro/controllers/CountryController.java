package com.jle.alexandro.controllers;

import com.jle.alexandro.models.entities.CountryEntity;
import com.jle.alexandro.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// example of a @RestController (if business process needed via service) Versus @RepositoryRestResource (which use hateoas)

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/countries__")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public List<CountryEntity> findAll() {
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public CountryEntity findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public CountryEntity create(@RequestBody CountryEntity country) {
        return service.create(country);
    }

    @PutMapping(path = {"/{id}"})
    public CountryEntity update(@PathVariable("id") Integer id, @RequestBody CountryEntity country) {
        country.setIdCountry(id);
        return service.update(country);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
