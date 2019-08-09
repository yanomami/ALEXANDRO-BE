package com.jle.alexandro.controllers;

import com.jle.alexandro.config.JwtTokenUtil;
import com.jle.alexandro.models.ApiResponse;
import com.jle.alexandro.models.AuthToken;
import com.jle.alexandro.models.LoginForm;
import com.jle.alexandro.models.RegistrationForm;
import com.jle.alexandro.models.entities.Client;
import com.jle.alexandro.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthentController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResponse<AuthToken> login(@RequestBody LoginForm loginForm) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        final Client user = accountService.findUserByUsername(loginForm.getUsername());

        final String token = jwtTokenUtil.generateToken(user);

        return new ApiResponse<>(200, "success",new AuthToken(token, user.getEmail()));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody RegistrationForm data) throws AuthenticationException {

        Client addedUser = accountService.register(data);

        final String token = jwtTokenUtil.generateToken(addedUser);

        return new ApiResponse<>(200, "success",new AuthToken(token, addedUser.getEmail()));
    }

}
