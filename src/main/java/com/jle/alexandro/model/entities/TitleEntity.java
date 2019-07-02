package com.jle.alexandro.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "title", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class TitleEntity {
    private Integer idTitle;
    private String description;
    private Set<ClientEntity> clientsByIdTitle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_title", nullable = false)
    public Integer getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(Integer idTitle) {
        this.idTitle = idTitle;
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
        TitleEntity that = (TitleEntity) o;
        return Objects.equals(idTitle, that.idTitle) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTitle, description);
    }

    @JsonBackReference
    @OneToMany(mappedBy = "titleByTitleId")
    public Set<ClientEntity> getClientsByIdTitle() {
        return clientsByIdTitle;
    }

    public void setClientsByIdTitle(Set<ClientEntity> clientsByIdTitle) {
        this.clientsByIdTitle = clientsByIdTitle;
    }
}
