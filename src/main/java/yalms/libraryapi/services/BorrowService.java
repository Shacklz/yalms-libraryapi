package yalms.libraryapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yalms.libraryapi.entities.nodes.LibraryUser;
import yalms.libraryapi.entities.nodes.multilabel.LibraryItem;
import yalms.libraryapi.entities.relationships.BorrowedByRel;
import yalms.libraryapi.repositories.LibraryItemRepository;
import yalms.libraryapi.repositories.LibraryUserRepository;

import java.time.LocalDateTime;

@Service
public class BorrowService {

    @Autowired private LibraryItemRepository libraryItemRepository;
    @Autowired private LibraryUserRepository libraryUserRepository;

    @Transactional
    public boolean borrowLibraryItem(Long libraryUserId, Long uniqueLibraryItemNumber) {
        boolean success = false;
        LibraryUser borrower = libraryUserRepository.findByLibraryUserId(libraryUserId);
        LibraryItem borrowItem = libraryItemRepository.findByUniqueLibraryItemNumber(uniqueLibraryItemNumber);
        success = borrower != null && borrowItem != null;
        if (success) {
            BorrowedByRel borrowedByRel = new BorrowedByRel(borrower, borrowItem);
            borrowedByRel.setBorrowDate(LocalDateTime.now());
            borrowItem.setBorrowedByRel(borrowedByRel);
        }
        libraryItemRepository.save(borrowItem);
        return success;
    }

    @Transactional
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
