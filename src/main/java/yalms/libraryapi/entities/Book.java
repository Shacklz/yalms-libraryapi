package yalms.libraryapi.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean available;

    @Relationship(type = "INSTANCE_OF_ABSTRACTBOOK", direction = Relationship.OUTGOING)
    private AbstractBook abstractBook;

    @Relationship(type = "HAS_BORROWED", direction = Relationship.INCOMING)
    private LibraryUser borrower;

    public AbstractBook getAbstractBook() {
        return abstractBook;
    }

    public void setAbstractBook(AbstractBook abstractBook) {
        this.abstractBook = abstractBook;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        available = available;
    }

    public LibraryUser getBorrower() {
        return borrower;
    }

    public void setBorrower(LibraryUser borrower) {
        this.borrower = borrower;
    }
}
