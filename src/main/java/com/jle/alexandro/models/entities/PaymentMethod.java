package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payment_method", schema = "dbo", catalog = "DB_ALEXANDRO")
public class PaymentMethod {
    private Integer id;
    private String description;
    private Set<Client> clientsById;

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
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @OneToMany(mappedBy = "paymentMethodByPaymentMethodId")
    public Set<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Set<Client> clientsById) {
        this.clientsById = clientsById;
    }
}
