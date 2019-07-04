package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {
    private Integer id;
    private String name;
    private Integer stock;
    private BigDecimal priceExVat;
    private byte[] picture;
    private Book bookById;
    private Set<OrderLine> orderLinesById;
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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stock", nullable = false)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "price_ex_vat", nullable = false, precision = 4)
    public BigDecimal getPriceExVat() {
        return priceExVat;
    }

    public void setPriceExVat(BigDecimal priceExVat) {
        this.priceExVat = priceExVat;
    }

    @Basic
    @Column(name = "picture", nullable = true)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(priceExVat, product.priceExVat) &&
                Arrays.equals(picture, product.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, stock, priceExVat);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @OneToOne(mappedBy = "productByProductId")
    public Book getBookById() {
        return bookById;
    }

    public void setBookById(Book bookById) {
        this.bookById = bookById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Set<OrderLine> getOrderLinesById() {
        return orderLinesById;
    }

    public void setOrderLinesById(Set<OrderLine> orderLinesById) {
        this.orderLinesById = orderLinesById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Set<ProductCategory> getProductCategoriesById() {
        return productCategoriesById;
    }

    public void setProductCategoriesById(Set<ProductCategory> productCategoriesById) {
        this.productCategoriesById = productCategoriesById;
    }
}
