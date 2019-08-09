package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.AddressRepository;
import com.jle.alexandro.models.entities.Address;
import com.jle.alexandro.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Address> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Address findById(Integer id) {
        Optional<Address> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Address update(Address resource) {
        return repository.save(resource);
    }

    @Override
    public Address create(Address resource) {
        return repository.save(resource);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
