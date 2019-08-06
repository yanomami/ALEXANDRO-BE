package com.jle.alexandro.services.impl;

import javax.transaction.Transactional;

import com.jle.alexandro.dao.ClientRepository;
import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private ClientRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Client saveUser(Client user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Client findUserByUsername(String username) {
        return userRepository.findClientByEmail(username);
    }
}
