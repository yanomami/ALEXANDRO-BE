package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
    private Integer id;
    private String name;
    private Set<Book> booksById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "publisherByPublisherId")
    public Set<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Set<Book> booksById) {
        this.booksById = booksById;
    }
}
