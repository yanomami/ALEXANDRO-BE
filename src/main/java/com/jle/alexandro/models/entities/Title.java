package com.jle.alexandro.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Title {
    private Integer id;
    private String description;
    @JsonBackReference
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
        Title title = (Title) o;
        return Objects.equals(id, title.id) &&
                Objects.equals(description, title.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @OneToMany(mappedBy = "titleByTitleId")
    public Set<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Set<Client> clientsById) {
        this.clientsById = clientsById;
    }
}
