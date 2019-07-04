package com.jle.alexandro.controllers;

import com.jle.alexandro.models.entities.Country;
import com.jle.alexandro.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// example for practice as spring data rest make already the job
// @RestController (if business process needed via service) Versus @RepositoryRestResource (which use hateoas & pageable)

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/countries_")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public List<Country> findAll() {
        return service.findAll();
    }

    @GetMapping(path = {"/pageable"})
    public Page<Country> findAll(Pageable pageable) {
        return service.findAllPageable(pageable);
    }

    @GetMapping(path = {"/{id}"})
    public Country findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        return service.create(country);
    }

    @PutMapping(path = {"/{id}"})
    public Country update(@PathVariable("id") Integer id, @RequestBody Country country) {
        country.setId(id);
        return service.update(country);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
