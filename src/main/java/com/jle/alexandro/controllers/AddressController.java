package com.jle.alexandro.controllers;

import com.jle.alexandro.models.entities.Address;
import com.jle.alexandro.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// example for practice as spring data rest make already the job
// @RestController (if business process needed via service) Versus @RepositoryRestResource (which use hateoas & pageable)

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/addresses_")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> findAll() {
        return service.findAll();
    }

    @GetMapping(path = {"/pageable"})
    public Page<Address> findAll(Pageable pageable) {
        return service.findAllPageable(pageable);
    }

    @GetMapping(path = {"/{id}"})
    public Address findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Address create(@RequestBody Address resource) {
        return service.create(resource);
    }

    @PutMapping(path = {"/{id}"})
    public Address update(@PathVariable("id") Integer id, @RequestBody Address resource) {
        resource.setId(id);
        return service.update(resource);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
