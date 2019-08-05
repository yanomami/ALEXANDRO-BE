package com.jle.alexandro.dao;

import com.jle.alexandro.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "results")
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @RestResource
    Client findClientByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
