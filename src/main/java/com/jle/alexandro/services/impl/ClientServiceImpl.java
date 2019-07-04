package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.ClientRepository;
import com.jle.alexandro.models.entities.ClientEntity;
import com.jle.alexandro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<ClientEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<ClientEntity> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ClientEntity findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public ClientEntity update(ClientEntity country) {
        return repository.save(country);
    }

    @Override
    public ClientEntity create(ClientEntity country) {
        return repository.save(country);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
