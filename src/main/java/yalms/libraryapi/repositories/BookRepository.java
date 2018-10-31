package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import yalms.libraryapi.entities.nodes.Book;

@Repository
public interface BookRepository extends Neo4jRepository<Book, Long> {
}
