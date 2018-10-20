package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import yalms.libraryapi.entities.nodes.LibraryUser;

public interface LibraryUserRepository extends Neo4jRepository<LibraryUser, Long> {
    @Query("MATCH (libUser: LibraryUser) return max(libUser.libraryUserId)")
    public Long getCurrentMaxId();

    public LibraryUser findByLibraryUserId(Long libraryUserId);
}