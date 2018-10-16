package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.nodes.AbstractBook;

public interface AbstractBookRepository extends Neo4jRepository<AbstractBook, Long> {

    public AbstractBook findByBookISBN13(String bookISBN13);
}
