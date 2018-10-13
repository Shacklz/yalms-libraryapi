package yalms.libraryapi.entities.relationships;

import org.neo4j.ogm.annotation.*;
import yalms.libraryapi.entities.nodes.AbstractBook;
import yalms.libraryapi.entities.nodes.Book;

@RelationshipEntity(type = "INSTANCE_OF_ABSTRACTBOOK")
public class InstanceOfAbstractBookRel {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Book book;

    @EndNode
    private AbstractBook abstractBook;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AbstractBook getAbstractBook() {
        return abstractBook;
    }

    public void setAbstractBook(AbstractBook abstractBook) {
        this.abstractBook = abstractBook;
    }
}
