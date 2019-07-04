package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {
    private Integer id;
    private String description;
    private Category categoryByParent;
    private Set<Category> categoriesById;
    private Set<ProductCategory> productCategoriesById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "id")
    public Category getCategoryByParent() {
        return categoryByParent;
    }

    public void setCategoryByParent(Category categoryByParent) {
        this.categoryByParent = categoryByParent;
    }

    @OneToMany(mappedBy = "categoryByParent")
    public Set<Category> getCategoriesById() {
        return categoriesById;
    }

    public void setCategoriesById(Set<Category> categoriesById) {
        this.categoriesById = categoriesById;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Set<ProductCategory> getProductCategoriesById() {
        return productCategoriesById;
    }

    public void setProductCategoriesById(Set<ProductCategory> productCategoriesById) {
        this.productCategoriesById = productCategoriesById;
    }
}
