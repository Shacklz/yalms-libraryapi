package yalms.libraryapi.entities.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import yalms.libraryapi.entities.relationships.HasBorrowedRel;

import java.time.LocalDate;
import java.util.Set;

@NodeEntity
public class LibraryUser {

    @Id
    @GeneratedValue
    private Long id;

    private Long libraryUserId;

    private String name;
    private LocalDate memberSinceDate;

    @Relationship(type = "HAS_BORROWED", direction = Relationship.OUTGOING)
    private Set<HasBorrowedRel> borrowedLibraryItemsRels;

    public Long getLibraryUserId() {
        return libraryUserId;
    }

    public void setLibraryUserId(Long libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public Set<HasBorrowedRel> getBorrowedLibraryItemsRels() {
        return borrowedLibraryItemsRels;
    }

    public void setBorrowedLibraryItemsRels(Set<HasBorrowedRel> borrowedLibraryItemsRels) {
        this.borrowedLibraryItemsRels = borrowedLibraryItemsRels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMemberSinceDate() {
        return memberSinceDate;
    }

    public void setMemberSinceDate(LocalDate memberSinceDate) {
        this.memberSinceDate = memberSinceDate;
    }
}
