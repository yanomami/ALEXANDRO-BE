package com.jle.alexandro.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Country {
    private Integer id;
    private String description;
    private Set<Address> addressesById;

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
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(description, country.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @JsonIgnore // TBC
    @OneToMany(mappedBy = "countryByCountryId")
    public Set<Address> getAddressesById() {
        return addressesById;
    }

    public void setAddressesById(Set<Address> addressesById) {
        this.addressesById = addressesById;
    }
}
