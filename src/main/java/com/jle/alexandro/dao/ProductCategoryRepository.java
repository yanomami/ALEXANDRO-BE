package com.jle.alexandro.dao;

import com.jle.alexandro.models.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "results", path = "productCategories")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
