package com.jle.alexandro.controllers;

import com.jle.alexandro.config.JwtTokenUtil;
import com.jle.alexandro.models.ApiResponse;
import com.jle.alexandro.models.AuthToken;
import com.jle.alexandro.models.RegistrationForm;
import com.jle.alexandro.models.entities.*;
import com.jle.alexandro.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody RegistrationForm data) throws AuthenticationException {

        Client addedUser = accountService.register(data);

        final String token = jwtTokenUtil.generateToken(addedUser);

        return new ApiResponse<>(200, "success",new AuthToken(token, addedUser.getEmail()));
    }

}
