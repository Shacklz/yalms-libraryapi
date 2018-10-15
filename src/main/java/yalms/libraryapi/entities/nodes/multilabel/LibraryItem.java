package yalms.libraryapi.entities.nodes.multilabel;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public abstract class LibraryItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long uniqueLibraryItemNumber;

    public Long getUniqueLibraryItemNumber() {
        return uniqueLibraryItemNumber;
    }

    public void setUniqueLibraryItemNumber(Long uniqueLibraryItemNumber) {
        this.uniqueLibraryItemNumber = uniqueLibraryItemNumber;
    }
}
