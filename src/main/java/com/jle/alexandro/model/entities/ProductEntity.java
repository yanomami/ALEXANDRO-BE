package com.jle.alexandro.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class ProductEntity {
    private Integer idProduct;
    private String name;
    private Integer stock;
    private BigDecimal priceExVat;
    private byte[] picture;
    private Set<BookEntity> booksByIdProduct;
    private Set<OrderLineEntity> orderLinesByIdProduct;
    private Set<ProductCategoryEntity> productCategoriesByIdProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(idProduct, that.idProduct) &&
                Objects.equals(name, that.name) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(priceExVat, that.priceExVat) &&
                Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idProduct, name, stock, priceExVat);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Set<BookEntity> getBooksByIdProduct() {
        return booksByIdProduct;
    }

    public void setBooksByIdProduct(Set<BookEntity> booksByIdProduct) {
        this.booksByIdProduct = booksByIdProduct;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Set<OrderLineEntity> getOrderLinesByIdProduct() {
        return orderLinesByIdProduct;
    }

    public void setOrderLinesByIdProduct(Set<OrderLineEntity> orderLinesByIdProduct) {
        this.orderLinesByIdProduct = orderLinesByIdProduct;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Set<ProductCategoryEntity> getProductCategoriesByIdProduct() {
        return productCategoriesByIdProduct;
    }

    public void setProductCategoriesByIdProduct(Set<ProductCategoryEntity> productCategoriesByIdProduct) {
        this.productCategoriesByIdProduct = productCategoriesByIdProduct;
    }
}
