package yalms.libraryapi.entities.relationships;

import org.neo4j.ogm.annotation.*;
import yalms.libraryapi.entities.nodes.LibraryUser;
import yalms.libraryapi.entities.nodes.multilabel.LibraryItem;

import java.time.LocalDateTime;

@RelationshipEntity(type = "HAS_BORROWED")
public class HasBorrowedRel {

    public HasBorrowedRel() {}

    public HasBorrowedRel(LibraryUser borrower, LibraryItem libraryItem) {
        this.borrower = borrower;
        this.libraryItem = libraryItem;
    }

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    LibraryUser borrower;

    @EndNode
    LibraryItem libraryItem;

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
