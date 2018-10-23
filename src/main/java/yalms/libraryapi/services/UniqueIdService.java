package yalms.libraryapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yalms.libraryapi.repositories.LibraryItemRepository;
import yalms.libraryapi.repositories.LibraryUserRepository;

@Service
public class UniqueIdService {

    @Autowired private LibraryItemRepository libraryItemRepository;
    @Autowired private LibraryUserRepository libraryUserRepository;

    public Long getNewUniqueLibraryItemId() {
        Long currentMax = libraryItemRepository.getCurrentMaxId();
        if (currentMax == null) return 0L;
        return currentMax + 1;
    }

    public Long getNewLibraryUserId() {
        Long currentMax = libraryUserRepository.getCurrentMaxId();
        if (currentMax == null) return 0L;
        return currentMax + 1;
    }
}
