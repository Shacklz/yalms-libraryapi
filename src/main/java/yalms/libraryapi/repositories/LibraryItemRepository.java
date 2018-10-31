package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import yalms.libraryapi.entities.nodes.multilabel.LibraryItem;

@Repository
public interface LibraryItemRepository extends Neo4jRepository<LibraryItem, Long> {

    @Query("MATCH (libItem: LibraryItem) return max(libItem.uniqueLibraryItemNumber)")
    Long getCurrentMaxId();

    LibraryItem findByUniqueLibraryItemNumber(Long uniqueLibraryItemNumber);
}