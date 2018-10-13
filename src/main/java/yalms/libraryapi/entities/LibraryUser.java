package yalms.libraryapi.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class LibraryUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "HAS_BORROWED", direction = Relationship.OUTGOING)
    private Set<Book> borrowedBooks;
}
