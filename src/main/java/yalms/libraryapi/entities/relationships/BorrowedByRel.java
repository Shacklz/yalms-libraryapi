package yalms.libraryapi.entities.relationships;

import org.neo4j.ogm.annotation.*;
import yalms.libraryapi.entities.nodes.LibraryUser;
import yalms.libraryapi.entities.nodes.multilabel.LibraryItem;

import java.time.LocalDateTime;

@RelationshipEntity(type = "BORROWED_BY")
public class BorrowedByRel {

    public BorrowedByRel() {}

    public BorrowedByRel(LibraryUser borrower, LibraryItem libraryItem) {
        this.borrower = borrower;
        this.libraryItem = libraryItem;
    }

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    LibraryItem libraryItem;

    @EndNode
    LibraryUser borrower;

    private LocalDateTime borrowDate;

    public LibraryUser getBorrower() {
        return borrower;
    }

    public void setBorrower(LibraryUser borrower) {
        this.borrower = borrower;
    }

    public LibraryItem getLibraryItem() {
        return libraryItem;
    }

    public void setLibraryItem(LibraryItem libraryItem) {
        this.libraryItem = libraryItem;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }
}
