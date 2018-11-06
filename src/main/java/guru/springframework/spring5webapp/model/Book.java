package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(){

    }

    public Book(String title, String isbn, String publiser){
        this.title = title;
        this.isbn = isbn;
        this.publisher = publiser;
    }

    public Book(String title, String isbn, String publiser, Set<Author> Author){
        this.title = title;
        this.isbn = isbn;
        this.publisher = publiser;
        this.authors = Author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}

    public String getisbn(){return isbn;}
    public void setisbn(String isbn){this.isbn = isbn;}

    public String getpubliser(){return publisher;}
    public void setpubliser(String publiser){this.publisher = publiser;}

    public Set<Author> getauthors(){return authors;}
    public void setAuthors(Set<Author> authors){this.authors = authors;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id!=null? id.equals(book.id) :book.id==null;
    }

    @Override
    public int hashCode() {
        return id!=null?id.hashCode():0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
