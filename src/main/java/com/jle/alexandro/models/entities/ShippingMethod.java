package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shipping_method", schema = "dbo", catalog = "DB_ALEXANDRO")
public class ShippingMethod {
    private Integer id;
    private String description;
    private BigDecimal charges;
    private Set<OrderHeader> orderHeadersById;

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

    @Basic
    @Column(name = "charges", nullable = false, columnDefinition="decimal", precision=19, scale=4)
    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingMethod that = (ShippingMethod) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(charges, that.charges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, charges);
    }

    @OneToMany(mappedBy = "shippingMethodByShippingMethodId")
    public Set<OrderHeader> getOrderHeadersById() {
        return orderHeadersById;
    }

    public void setOrderHeadersById(Set<OrderHeader> orderHeadersById) {
        this.orderHeadersById = orderHeadersById;
    }
}
