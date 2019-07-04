package com.jle.alexandro.controllers;

import com.jle.alexandro.models.entities.ClientEntity;
import com.jle.alexandro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// example for practice as spring data rest make already the job
// @RestController (if business process needed via service) Versus @RepositoryRestResource (which use hateoas & pageable)

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/clients_")
public class ClientsController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<ClientEntity> findAll() {
        return service.findAll();
    }

    @GetMapping(path = {"/pageable"})
    public Page<ClientEntity> findAll(Pageable pageable) {
        return service.findAllPageable(pageable);
    }

    @GetMapping(path = {"/{id}"})
    public ClientEntity findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public ClientEntity create(@RequestBody ClientEntity country) {
        return service.create(country);
    }

    @PutMapping(path = {"/{id}"})
    public ClientEntity update(@PathVariable("id") Integer id, @RequestBody ClientEntity country) {
        country.setIdClient(id);
        return service.update(country);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
