package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.Client;

public interface AccountService {
    public Client saveUser(Client user);
    public Client findUserByUsername(String username);
}
