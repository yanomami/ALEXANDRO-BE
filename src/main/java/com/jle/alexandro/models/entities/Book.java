package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    private Integer id;
    private String isbn;
    private String title;
    private Integer nbPages;
    private Product productByProductId;
    private Author authorByAuthorId;
    private Publisher publisherByPublisherId;
    private Collection collectionByCollectionId;
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
    @Column(name = "isbn", nullable = false, length = 13)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "nb_pages", nullable = true)
    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(nbPages, book.nbPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, nbPages);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", nullable = false)
    public Publisher getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(Publisher publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }

    @ManyToOne
    @JoinColumn(name = "collection_id", referencedColumnName = "id", nullable = false)
    public Collection getCollectionByCollectionId() {
        return collectionByCollectionId;
    }

    public void setCollectionByCollectionId(Collection collectionByCollectionId) {
        this.collectionByCollectionId = collectionByCollectionId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Set<BookGenre> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Set<BookGenre> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}
