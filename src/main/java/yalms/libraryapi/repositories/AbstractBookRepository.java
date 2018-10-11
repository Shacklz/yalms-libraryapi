package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.AbstractBook;

public interface AbstractBookRepository extends Neo4jRepository<AbstractBook, Long> {
}
