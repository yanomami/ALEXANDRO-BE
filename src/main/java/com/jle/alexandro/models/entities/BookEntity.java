package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class BookEntity {
    private Integer idBook;
    private String isbn;
    private String title;
    private Integer nbPages;
    private ProductEntity productByProductId;
    private AuthorEntity authorByAuthorId;
    private PublisherEntity publisherByPublisherId;
    private CollectionEntity collectionByCollectionId;
    private Set<BookGenreEntity> bookGenresByIdBook;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book", nullable = false)
    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
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
        BookEntity that = (BookEntity) o;
        return Objects.equals(idBook, that.idBook) &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(title, that.title) &&
                Objects.equals(nbPages, that.nbPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook, isbn, title, nbPages);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id_product", nullable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id_author", nullable = false)
    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "id_publisher", nullable = false)
    public PublisherEntity getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(PublisherEntity publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }

    @ManyToOne
    @JoinColumn(name = "collection_id", referencedColumnName = "id_collection", nullable = false)
    public CollectionEntity getCollectionByCollectionId() {
        return collectionByCollectionId;
    }

    public void setCollectionByCollectionId(CollectionEntity collectionByCollectionId) {
        this.collectionByCollectionId = collectionByCollectionId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Set<BookGenreEntity> getBookGenresByIdBook() {
        return bookGenresByIdBook;
    }

    public void setBookGenresByIdBook(Set<BookGenreEntity> bookGenresByIdBook) {
        this.bookGenresByIdBook = bookGenresByIdBook;
    }
}
