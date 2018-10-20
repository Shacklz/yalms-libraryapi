package yalms.libraryapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yalms.libraryapi.entities.nodes.LibraryUser;
import yalms.libraryapi.entities.nodes.multilabel.LibraryItem;
import yalms.libraryapi.entities.relationships.HasBorrowedRel;
import yalms.libraryapi.repositories.LibraryItemRepository;
import yalms.libraryapi.repositories.LibraryUserRepository;

import java.time.LocalDateTime;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BorrowService {

    @Autowired LibraryItemRepository libraryItemRepository;
    @Autowired LibraryUserRepository libraryUserRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean borrowLibraryItem(Long libraryUserId, Long uniqueLibraryItemNumber) {
        boolean success = false;
        LibraryUser libraryUser = libraryUserRepository.findByLibraryUserId(libraryUserId);
        LibraryItem libraryItem = libraryItemRepository.findByUniqueLibraryItemNumber(uniqueLibraryItemNumber);
        success = libraryUser != null && libraryItem != null;
        if (success) {
            HasBorrowedRel hasBorrowedRel = new HasBorrowedRel(libraryUser, libraryItem);
            hasBorrowedRel.setBorrowDate(LocalDateTime.now());
            libraryItem.setBorrowedByRel(hasBorrowedRel);
        }
        libraryItemRepository.save(libraryItem);
        return success;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean bringBackLibraryItem(Long uniqueLibraryItemNumber) {
        boolean success = false;
        LibraryItem libraryItem = libraryItemRepository.findByUniqueLibraryItemNumber(uniqueLibraryItemNumber);
        success = libraryItem != null;
        if (success) {
            libraryItem.setBorrowedByRel(null);
            libraryItemRepository.save(libraryItem);
        }
        return success;
    }
}
