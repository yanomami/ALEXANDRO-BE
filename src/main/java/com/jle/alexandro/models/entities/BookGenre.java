package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_genre", schema = "dbo", catalog = "DB_ALEXANDRO")
@IdClass(BookGenrePK.class)
public class BookGenre {
    private Integer bookId;
    private Integer genreId;
    private Book bookByBookId;
    private Genre genreByGenreId;

    @Id
    @Column(name = "book_id", nullable = false)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Id
    @Column(name = "genre_id", nullable = false)
    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenre bookGenre = (BookGenre) o;
        return Objects.equals(bookId, bookGenre.bookId) &&
                Objects.equals(genreId, bookGenre.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genreId);
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Genre getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(Genre genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }
}
