package yalms.libraryapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import yalms.libraryapi.entities.nodes.LibraryUser;

@Repository
public interface LibraryUserRepository extends Neo4jRepository<LibraryUser, Long> {
    @Query("MATCH (libUser: LibraryUser) return max(libUser.libraryUserId)")
    Long getCurrentMaxId();

    LibraryUser findByLibraryUserId(Long libraryUserId);
}