package yalms.libraryapi.entities.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;

@NodeEntity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate addedToLibraryDate;

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

    public LibraryUser getBorrower() {
        return borrower;
    }

    public void setBorrower(LibraryUser borrower) {
        this.borrower = borrower;
    }

    public LocalDate getAddedToLibraryDate() {
        return addedToLibraryDate;
    }

    public void setAddedToLibraryDate(LocalDate addedToLibraryDate) {
        this.addedToLibraryDate = addedToLibraryDate;
    }

}
