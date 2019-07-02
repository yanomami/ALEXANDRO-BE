package com.jle.alexandro.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "genre", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class GenreEntity {
    private Integer idGenre;
    private String description;
    private Collection<BookGenreEntity> bookGenresByIdGenre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre", nullable = false)
    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
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
        GenreEntity that = (GenreEntity) o;
        return Objects.equals(idGenre, that.idGenre) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre, description);
    }

    @OneToMany(mappedBy = "genreByGenreId")
    public Collection<BookGenreEntity> getBookGenresByIdGenre() {
        return bookGenresByIdGenre;
    }

    public void setBookGenresByIdGenre(Collection<BookGenreEntity> bookGenresByIdGenre) {
        this.bookGenresByIdGenre = bookGenresByIdGenre;
    }
}
