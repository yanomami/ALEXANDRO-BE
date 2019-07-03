package com.jle.alexandro;

//In case you need to expose the identifiers for all entities (as they are not expose with sprint data rest @RepositoryRestResource).
//The best solution would be not to using the IDs of your entities, and use the link references the hypermedia provides.
//You just need to parse your JSON accordingly to the HAL specification used by Spring Data Rest.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                entityManager.getMetamodel().getEntities().stream()
                        .map(Type::getJavaType)
                        .toArray(Class[]::new));
    }
}