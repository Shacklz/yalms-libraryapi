package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.Book;

public interface BookRepository extends Neo4jRepository<Book, Long> {
}
