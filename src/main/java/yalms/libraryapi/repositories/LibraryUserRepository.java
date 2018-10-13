package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.LibraryUser;

public interface LibraryUserRepository extends Neo4jRepository<LibraryUser, Long> {
}