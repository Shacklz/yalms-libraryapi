package yalms.libraryapi.entities.relationships;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.time.LocalDateTime;

@RelationshipEntity(type = "HAS_BORROWED")
public class HasBorrowedRel {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime borrowDate;

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }
}