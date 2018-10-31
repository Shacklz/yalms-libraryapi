package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import yalms.libraryapi.entities.nodes.AbstractBook;

@Repository
public interface AbstractBookRepository extends Neo4jRepository<AbstractBook, Long> {

    AbstractBook findByBookISBN13(String bookISBN13);
}
