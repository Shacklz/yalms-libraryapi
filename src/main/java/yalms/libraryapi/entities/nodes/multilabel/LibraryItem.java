package yalms.libraryapi.entities.nodes.multilabel;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import yalms.libraryapi.entities.relationships.BorrowedByRel;

@NodeEntity
public abstract class LibraryItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long uniqueLibraryItemNumber;

    @Relationship(type = "BORROWED_BY", direction = Relationship.OUTGOING)
    private BorrowedByRel borrowedByRel;

    public Long getUniqueLibraryItemNumber() {
        return uniqueLibraryItemNumber;
    }

    public void setUniqueLibraryItemNumber(Long uniqueLibraryItemNumber) {
        this.uniqueLibraryItemNumber = uniqueLibraryItemNumber;
    }

    public BorrowedByRel getBorrowedByRel() {
        return borrowedByRel;
    }

    public void setBorrowedByRel(BorrowedByRel borrowedByRel) {
        this.borrowedByRel = borrowedByRel;
    }
}
