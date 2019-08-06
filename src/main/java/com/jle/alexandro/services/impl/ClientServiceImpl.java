package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.ClientRepository;
import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Client> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Client findById(Integer id) {
        Optional<Client> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Client update(Client resource) {
        return repository.save(resource);
    }

    @Override
    public Client create(Client resource) {
        return repository.save(resource);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
