package yalms.libraryapi.entities.relationships;

import org.neo4j.ogm.annotation.*;
import yalms.libraryapi.entities.nodes.Book;
import yalms.libraryapi.entities.nodes.LibraryUser;

import java.time.LocalDateTime;

@RelationshipEntity(type = "HAS_BORROWED")
public class HasBorrowedRel {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    LibraryUser borrower;

    @EndNode
    Book borrowedBook;

    private LocalDateTime borrowDate;

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }
}
