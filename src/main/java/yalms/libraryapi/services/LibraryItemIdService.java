package yalms.libraryapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yalms.libraryapi.repositories.LibraryItemRepository;

@Service
public class LibraryItemIdService {
    @Autowired
    LibraryItemRepository libraryItemRepository;

    public long getNewUniqueLibraryItemId() {
        Long currentMax = libraryItemRepository.getCurrentMaxId();
        if (currentMax == null) return 0;
        return currentMax + 1;
    }
}
