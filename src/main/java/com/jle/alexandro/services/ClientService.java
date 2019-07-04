package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Page<Client> findAllPageable(Pageable pageable);
    Client findById(Integer id);
    Client create(Client country);
    Client update(Client country);
    void delete(Integer id);
}
