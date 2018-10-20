package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.nodes.multilabel.LibraryItem;

public interface LibraryItemRepository extends Neo4jRepository<LibraryItem, Long> {

    @Query("MATCH (libItem: LibraryItem) return max(libItem.uniqueLibraryItemNumber)")
    public Long getCurrentMaxId();

    public LibraryItem findByUniqueLibraryItemNumber(Long uniqueLibraryItemNumber);
}