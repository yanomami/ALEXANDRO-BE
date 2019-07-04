package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Genre {
    private Integer id;
    private String description;
    private Set<BookGenre> bookGenresById;

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
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id) &&
                Objects.equals(description, genre.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @OneToMany(mappedBy = "genreByGenreId")
    public Set<BookGenre> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Set<BookGenre> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}
