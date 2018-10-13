package yalms.libraryapi.entities.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;
import java.util.Set;

@NodeEntity
public class LibraryUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDate memberSinceDate;

    @Relationship(type = "HAS_BORROWED", direction = Relationship.OUTGOING)
    private Set<Book> borrowedBooks;

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Set<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
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
