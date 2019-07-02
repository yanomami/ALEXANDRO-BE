package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_genre", schema = "dbo", catalog = "DB_ALEXANDRIA")
@IdClass(BookGenreEntityPK.class)
public class BookGenreEntity {
    private Integer bookId;
    private Integer genreId;
    private BookEntity bookByBookId;
    private GenreEntity genreByGenreId;

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
        BookGenreEntity that = (BookGenreEntity) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genreId);
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id_book", nullable = false, insertable = false, updatable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id_genre", nullable = false, insertable = false, updatable = false)
    public GenreEntity getGenreByGenreId() {
        return genreByGenreId;
    }

    public void setGenreByGenreId(GenreEntity genreByGenreId) {
        this.genreByGenreId = genreByGenreId;
    }
}
