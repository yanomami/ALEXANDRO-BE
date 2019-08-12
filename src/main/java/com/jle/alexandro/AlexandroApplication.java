package com.jle.alexandro;

import com.jle.alexandro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AlexandroApplication implements CommandLineRunner {

/*    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;*/

/*
    @Autowired
    private ClientService service;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/

    public static void main(String[] args) {
        SpringApplication.run(AlexandroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //In case you need to expose the identifiers for all entities (as they are not expose with spring data rest @RepositoryRestResource):
        //repositoryRestConfiguration.exposeIdsFor(CountryEntity.class);
        //repositoryRestConfiguration.exposeIdsFor(ClientEntity.class);
        //-> Cf. file RestConfiguration

        // SET ALL CLIENTS PASSWORD = "Peenahe1" (with encryption) (rq: the passwords from sql file are not encrypted, they can't be decrypted)
 /*
        service.findAll().forEach(client -> {
            client.setPassword(passwordEncoder.encode("Peenahe1"));
            service.update(client);
        }); }
        */
    }
}
