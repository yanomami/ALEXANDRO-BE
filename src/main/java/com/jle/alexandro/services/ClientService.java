package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    List<ClientEntity> findAll();
    Page<ClientEntity> findAllPageable(Pageable pageable);
    ClientEntity findById(Integer id);
    ClientEntity create(ClientEntity country);
    ClientEntity update(ClientEntity country);
    void delete(Integer id);
}
