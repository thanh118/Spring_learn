package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(){
    }

    public Author(String firstName, String lastName){
        this.firstname = firstName;
        this.lastname = lastName;
    }

    public Author(String firstName, String lastName, Set<Book> books){
        this.firstname = firstName;
        this.lastname = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtname(){return firstname;}
    public void setFirstName(String firstName){this.firstname = firstName; }

    public String getlastname(){return lastname;}
    public void setlastName(String lastName){this.lastname = lastName ;}

    public Set<Book> getbooks(){return books;}
    public void setbooks(Set<Book> books){this.books = books ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id!=null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id!=null ? id.hashCode():0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }
}
