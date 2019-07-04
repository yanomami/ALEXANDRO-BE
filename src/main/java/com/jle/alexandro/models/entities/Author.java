package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    private String bio;
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
    @Column(name = "first_name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "bio", nullable = true, length = -1)
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(bio, author.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, bio);
    }

    @OneToMany(mappedBy = "authorByAuthorId")
    public Set<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Set<Book> booksById) {
        this.booksById = booksById;
    }
}
