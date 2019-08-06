package com.jle.alexandro.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterUser {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
