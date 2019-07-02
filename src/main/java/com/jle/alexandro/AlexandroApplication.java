package com.jle.alexandro;

import com.jle.alexandro.models.entities.ClientEntity;
import com.jle.alexandro.models.entities.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AlexandroApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(AlexandroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(CountryEntity.class);
        repositoryRestConfiguration.exposeIdsFor(ClientEntity.class);
    }
}
