package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.nodes.Book;

public interface BookRepository extends Neo4jRepository<Book, Long> {
}
