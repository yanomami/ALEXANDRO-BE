package com.jle.alexandro.services.impl;

import com.jle.alexandro.dao.ClientRepository;
import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class ClientServiceImpl implements ClientService, UserDetailsService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

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
        resource.setPassword(bcryptEncoder.encode(resource.getPassword()));
        return repository.save(resource);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

/*
    Security
*/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user = repository.findClientByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public Client findUserByUsername(String username) {
        return repository.findClientByEmail(username);
    }
}
