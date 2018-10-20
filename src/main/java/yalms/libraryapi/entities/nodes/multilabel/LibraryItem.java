package yalms.libraryapi.entities.nodes.multilabel;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import yalms.libraryapi.entities.relationships.HasBorrowedRel;

@NodeEntity
public abstract class LibraryItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long uniqueLibraryItemNumber;

    @Relationship(type = "HAS_BORROWED", direction = Relationship.INCOMING)
    private HasBorrowedRel borrowedByRel;

    public Long getUniqueLibraryItemNumber() {
        return uniqueLibraryItemNumber;
    }

    public void setUniqueLibraryItemNumber(Long uniqueLibraryItemNumber) {
        this.uniqueLibraryItemNumber = uniqueLibraryItemNumber;
    }

    public HasBorrowedRel getBorrowedByRel() {
        return borrowedByRel;
    }

    public void setBorrowedByRel(HasBorrowedRel borrowedByRel) {
        this.borrowedByRel = borrowedByRel;
    }
}
