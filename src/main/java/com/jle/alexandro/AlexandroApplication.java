package com.jle.alexandro;

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
        //In case you need to expose the identifiers for all entities (as they are not expose with sprint data rest @RepositoryRestResource):
        //repositoryRestConfiguration.exposeIdsFor(CountryEntity.class);
        //repositoryRestConfiguration.exposeIdsFor(ClientEntity.class);
        //-> Cf. file RestConfiguration
    }
}
