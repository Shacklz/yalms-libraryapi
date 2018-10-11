package yalms.libraryapi.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "INSTANCE_OF_ABSTRACTBOOK", direction = Relationship.OUTGOING)
    AbstractBook abstractBook;
}
