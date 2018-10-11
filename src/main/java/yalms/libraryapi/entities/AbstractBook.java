package yalms.libraryapi.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class AbstractBook {

    @Id
    @GeneratedValue
    private Long id;

    private String bookName;
    private String bookAuthor;
    private String bookISBN10;
    private String bookISBN13;

    @Relationship(type = "INSTANCE_OF_ABSTRACTBOOK", direction = Relationship.INCOMING)
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookISBN10() {
        return bookISBN10;
    }

    public void setBookISBN10(String bookISBN10) {
        this.bookISBN10 = bookISBN10;
    }

    public String getBookISBN13() {
        return bookISBN13;
    }

    public void setBookISBN13(String bookISBN13) {
        this.bookISBN13 = bookISBN13;
    }
}
