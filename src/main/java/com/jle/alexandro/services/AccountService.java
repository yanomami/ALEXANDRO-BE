package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    public Client saveUser(Client user);
    public Client findUserByUsername(String username);
}
