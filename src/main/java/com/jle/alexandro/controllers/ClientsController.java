package com.jle.alexandro.controllers;

import com.jle.alexandro.models.entities.Client;
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
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping(path = {"/pageable"})
    public Page<Client> findAll(Pageable pageable) {
        return service.findAllPageable(pageable);
    }

    @GetMapping(path = {"/{id}"})
    public Client findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client resource) {
        return service.create(resource);
    }

    @PutMapping(path = {"/{id}"})
    public Client update(@PathVariable("id") Integer id, @RequestBody Client resource) {
        resource.setId(id);
        return service.update(resource);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
